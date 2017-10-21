package core;

/**
 * Hard-to-get-it-right implementation of a Singleton supporting lazy
 * instantiation.
 */
public class SingletonPattern implements Cloneable {
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 6462568326558031828L; 

	/*
	 * Marking volatile is necessary for avoiding the threads from creating
	 * their own copies, even with double checked locking.
	 */
	private static volatile SingletonPattern INSTANCE = null;
	
	/*
	 * Guard against 'reflection' to create a new instance.
	 */
	private SingletonPattern() {
		if (INSTANCE != null) {
			throw new IllegalStateException();
		}
	}

	/*
	 * Synchronizes only on the critical section, and uses double checked
	 * locking to ensure that all get requests are not Synchronized once the
	 * instance is created.
	 */
	public static SingletonPattern getInstance() {
		if (INSTANCE == null) {
			synchronized (SingletonPattern.class) {
				if (INSTANCE == null) {
					INSTANCE = new SingletonPattern();
				}
			}
		}
		return INSTANCE;
	}

	/**
	 * Yeah, why dont you try cloning me?
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();

	}
}
