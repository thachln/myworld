package mksgroup.myworld.sum.implement;

import mksgroup.myworld.sum.ResultObject;
import mksgroup.myworld.sum.abtract.INotifier;

/**
 * Class implements INotifier interface
 * Override send function of INotifier interface to parse 
 * all parameters of send method to ResultObject
 * @author Admin
 *
 */
public class HandleINotifier implements INotifier {

	// resultObject dùng để chứa thông tin cho các parameter từ send function
	private ResultObject resultObject;

	public void setResultObject(ResultObject resultObject) {
		this.resultObject = resultObject;
	}

	/**
	 *  <p>
	 * Chúng ta truyền vào một ResultObject khi khởi tạo HandleINotifier  
	 * Sau khi send method được gọi thì resultObject  mà chúng ta struyền vào cũng đã có
	 * các giá trị cần thiết. Tương tự như việc chúng ta đã truyền tham chiếu vào class này
	 *  và thay đổi giá trị của nó.
	 * @param resultObject	
	 * Parameter sẽ chứa các thông tin mà chúng ta sẽ nhận lại sau khi tính toán
	 *
	 */
	public HandleINotifier(ResultObject resultObject) {
		this.resultObject = resultObject;
	}

	@Override
	public void send(String result, int carry, double percentage, int index, int sum, int lastCarry) {

		this.resultObject.setIndex(index);
		this.resultObject.setPercentage(percentage);
		this.resultObject.setCarry(carry);
		this.resultObject.setResult(result);
		this.resultObject.setSum(sum);
		this.resultObject.setLastCarry(lastCarry);
		
	}

}
