package utility;

public class TestExecutorContainer {

	private static ThreadLocal<TestExecutor> threadLocal = new ThreadLocal<TestExecutor>();

	public static void setTestExecutor(TestExecutor testExecutor) {
		threadLocal.set(testExecutor);
	}

	public static TestExecutor getTestExecutor() {
		return threadLocal.get();
	}
}
