package mksgroup.myworld.sum.bus;

import mksgroup.myworld.sum.ResultObject;
import mksgroup.myworld.sum.abtract.INotifier;

/**
 * This class has findSum function Allow add two string as integer
 * 
 * @author Phong Nguyen
 * @version 1.0
 *
 */
public class SumTwoString {

	private INotifier nontifier;
	// Index của phần tử mà chúng ta đang tính
	private int index = 0;
	// Số dư sau khi thực hiện xong phép tính
	private int carry = 0;
	// Vị trí kết thúc của phép tính
	private int endIndex;
	// Kết quả từ lần tính toán trước
	private String lastResult = "";
	// Biến này để xác định xem chúng ta có thực hiện tính toán từng bước không
	// Nếu isStep = true; thì tính theo từ bước 1,
	// Nếu isStep = false thì method findSum sẽ tính từ vị trí bắt đầu là 0
	// và kết thúc khi index = độ dài lớn nhất của chuỗi numberA hoặc numberB
	private boolean isStep = false;

	/**
	 * 
	 * @param nontifier
	 *            class implements INontifier interface, Determine what the send
	 *            function will do
	 * @param lastResultObject
	 *            ResultObject which contains info of ResultObject from previous
	 *            times calculation
	 */
	public SumTwoString(INotifier nontifier, ResultObject lastResultObject) {
		this.nontifier = nontifier;
		if (lastResultObject != null) {
			this.index = lastResultObject.getIndex();
			this.carry = lastResultObject.getCarry();
			this.lastResult = lastResultObject.getResult();
			this.endIndex = index + 1;
			this.isStep = true;
		}
	}

	public String findSum(final String numberA, final String numberB) {

		int a = 0;
		int b = 0;
		int carry = this.carry;
		int indexA = 0;
		int indexB = 0;
		int sum = 0;
		int max = numberA.length() > numberB.length() ? numberA.length() : numberB.length();
		double percentage = 0.0;
		// Gán kết quả là kết quả từ lần thực hiện tính toán trước để có thể nhận được
		// kết quả cho lần tính toán này
		String result = this.lastResult;
		// Nếu request không phải là để thự hiện tính từng bước thì ta
		// sẽ thực hiện tính cho đến kết thúc quá trình tính
		if (!isStep) {
			endIndex = max;
		}
		for (int i = 0; i < max; i++) {

			i = index;
			a = b = 0;
			indexA = numberA.length() - i - 1;
			indexB = numberB.length() - i - 1;

			if (indexA >= 0) {
				a = numberA.charAt(indexA) - '0';
			}

			if (indexB >= 0) {
				b = numberB.charAt(indexB) - '0';
			}

			sum = a + b + carry;
			carry = sum / 10;
			result = sum % 10 + result;
			this.lastResult = result;
			// Gán giá trị cho tiến độ hoàn thành của công việc
			percentage = (double) Math.round((i + 1) * 10000 / max) / 100;

			// Send dữ liệu về các thay đổi trong lúc thực hiện tính toán ra ngoài
			nontifier.send(result, carry, percentage, i, sum, sum - a - b);
			// Kết thúc vòng lặp khi giá trị của i đã đạt đến endIndex
			if (i == endIndex - 1) {
				break;
			}
		}

		if (carry > 0) {
			result = carry + result;
		}

		return result == "" ? "0" : result;
	}
}
