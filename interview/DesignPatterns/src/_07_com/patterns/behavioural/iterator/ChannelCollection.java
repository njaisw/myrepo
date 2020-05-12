package _07_com.patterns.behavioural.iterator;

// Iterator is part of Collection
public interface ChannelCollection {

	public void addChannel(Channel c);

	public void removeChannel(Channel c);

	public ChannelIterator iterator(ChannelTypeEnum type);

}