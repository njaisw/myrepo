package _07_com.patterns.behavioural.iterator;

public class Channel {

	private double frequency;
	private ChannelTypeEnum TYPE;

	public Channel(double freq, ChannelTypeEnum type) {
		this.frequency = freq;
		this.TYPE = type;
	}

	public double getFrequency() {
		return frequency;
	}

	public ChannelTypeEnum getTYPE() {
		return TYPE;
	}

	@Override
	public String toString() {
		return "Frequency=" + this.frequency + ", Type=" + this.TYPE;
	}

}