package mksgroup.myworld.sum.abtract;

public interface INotifier {
	/**
	 * 
	 * @param result Kết quả của phép tính
	 * @param carry Số nhớ sau khi thực hiện phép tính
	 * @param percentage tỉ lệ hoàn thành công việc (%)
	 * @param index vị trí của số được tính
	 * @param sum tổng của hai số trong hai chuỗi được tính và carry
	 * @param lastCarry Số dư từ lần tính toán trước
	 */
	public void send(String result, int carry, double percentage, int index, int sum, int lastCarry);
}
