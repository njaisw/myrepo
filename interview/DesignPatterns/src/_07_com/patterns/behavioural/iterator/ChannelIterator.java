package _07_com.patterns.behavioural.iterator;

// Iterator has usually 2 methods hasNext and next
public interface ChannelIterator {

	public boolean hasNext();

	public Channel next();
}