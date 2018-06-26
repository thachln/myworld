package mksgroup.myworld.sum.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mksgroup.myworld.sum.ResultObject;
import mksgroup.myworld.sum.MyWorldSumApplication;
import mksgroup.myworld.sum.bus.SumTwoString;
import mksgroup.myworld.sum.implement.HandleINotifier;

@Controller
public class HomeController {

	private SumTwoString sumProvider;
	private String sessionNumberA = "sessionNumberA";
	private String sessionNumberB = "sessionNumberB";
	private String sessionResultObject = "sessionResultObject";
	private HandleINotifier notifier;

	@Autowired
	MyWorldSumApplication sumTwoNumberApp;

	@GetMapping("/")
	public String index() {

		return "index";
	}

	// Method được gọi với post method và từ phía client
	// Tương ứng với việc nhấn submit button
	@PostMapping("/")
	public @ResponseBody ResultObject index(HttpServletRequest request, String numberA, String numberB) {

		// Cùng với việc submit đồng nghĩa với việc reset lại toàn bộ quá trình tính toán
		// Hoặc thực hiện tính một lần tính mới
		// Đầu tiên ta lưu lại giá trị cho session ứng với key là giá trị của các biến
		// sessionNumberA và sessionNumberB
		request.getSession().setAttribute(sessionNumberA, numberA);
		request.getSession().setAttribute(sessionNumberB, numberB);

		// Sau khi lưu lại giá trị mới cho numberA và numberB session
		// Chúng ta thực hiện khởi tạo một ResultObject mới
		// ResultObject là một Object chứa tất cả các thông tin
		// Chúng ta sẽ response về client
		// Reinitialize the whole object
		ResultObject resultObject = new ResultObject();

		// Set the reset object into notifier

		// Tiếp theo chúng ta khởi tạo một instance mới cho HandleINotifier và gán nó
		// cho biến notifier
		// HandleINotifier là một class implements lại INotifier interface
		// Với nhiệm vụ chính là override lại send method của INotifier
		// Để gán các giá trị trong tham số được truyền vào từ hàm send này vào
		// Các giá trị tương ứng trong resultObject mà chúng ta sẽ response về cho
		// client
		notifier = new HandleINotifier(resultObject);

		// Khởi tạo một instance mới của SumTwoString và truyền vào 2 parmater
		// là notifier và resultObject mà chúng ta đã khai báo ở trên
		// Initialize new instance of SumTwoString with two parameters which are
		// initialized above into sumProvider
		sumProvider = new SumTwoString(notifier, resultObject);

		// Tiếp theo chúng ta gọi hàm findSum trong để thực hiện phép tính
		// Đồng thời việc này giúp cập nhật lại thông tin cho resultObject của chúng ta
		sumProvider.findSum(numberA, numberB);

		// Chúng ta lưu resultObject vào session để có thể sử dụng trong các lần request
		// tiếp theo
		request.getSession().setAttribute(sessionResultObject, resultObject);

		return resultObject;
	}

	// Method này được gọi với post method từ phía client
	// Tương ứng với việc nhất next button
	@PostMapping("/next")
	public @ResponseBody ResultObject nextStep(HttpServletRequest request) {

		// Vì đây là method được gọi khi bấm next button nên chúng ta mặc định
		// là đã có các dữ liệu trong session từ việc lưu vào session khi nhấn submit
		// hoặc từ chính method này chỉ cần lấy ra để sử dụng

		// Đầu tiên chúng ta lấy ra resultObject từ lần tính toán trước
		ResultObject resultObject = (ResultObject) request.getSession().getAttribute(sessionResultObject);

		// Set lại index mới cho resultObject để thực hiện tiếp phép toán từ lần trước
		// Index sẽ được sử dụng để xác định vị trí trong chuỗi chúng ta sẽ thực hiệp
		// phép tính
		// index trong resultObject chính là index của lần tính toán trước
		// Để thực hiện để tính số tiếp theo trong lần này chúng ta tăng lên 1 đơn vị
		resultObject.setIndex(resultObject.getIndex() + 1);

		// lấy numberA và numberB được lưu vào session trong lần tính toán trước
		String numberA = (String) request.getSession().getAttribute(sessionNumberA);
		String numberB = (String) request.getSession().getAttribute(sessionNumberB);

		// Khởi tạo lại notifier với resultObject mới có đầy đủ thông tin cho lần tính
		// toán lần này
		notifier = new HandleINotifier(resultObject);

		// Tiếp theo chúng ta gọi hàm findSum trong để thực hiện phép tính
		// Đồng thời việc này giúp cập nhật lại thông tin cho resultObject của chúng ta
		sumProvider = new SumTwoString(notifier, resultObject);
		sumProvider.findSum(numberA, numberB);
		// Chúng ta lưu resultObject vào session để
		// có thể sử dụng trong các lần request tiếp theo
		request.getSession().setAttribute(sessionResultObject, resultObject);

		return resultObject;
	}
}
