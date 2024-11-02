package practice.structural.proxy;

import practice.structural.proxy.Developer.Type;

/**
 * Example of Proxy Design Pattern
 */
public final class ProxyDemo {

  public static void main(final String[] arguments) {

    final var room = new InterviewRoom();
    final var proxy = new RoomProxy(room);

    proxy.use(new Developer(Type.INTERVIEWER));
    proxy.use(new Developer(Type.INTERVIEWEE));

    proxy.use(new Developer(Type.INTERVIEWER));
    proxy.use(new Developer(Type.INTERVIEWEE));
  }
}
