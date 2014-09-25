package main;

public class TimeCalc
{
	private static long msPerWeek = 604_800_000;
	private static long msPerDay  =  86_400_000;
	private static long msPerHour =   3_600_000;
	private static long msPerMin  =      60_000;
	private static long msPerSec  =       1_000;
	
	public static String calcPrettyTime(long diff)
	{
		long weeks = diff / msPerWeek;
		long days  = diff / msPerDay;
		long hours = diff / msPerHour;
		long mins  = diff / msPerMin;
		long secs  = diff / msPerSec;

		if ( days >= 21 )
			return new Long(weeks).toString() + " weeks ago";
		if ( days >=  3 )
			return new Long(days ).toString() + " days ago";
		if ( days >=  1 )
			return new Long(days ).toString() + " days "    + new Long(hours % 24).toString() + " hours ago";
		if (hours >=  1 )
			return new Long(hours).toString() + " hours "   + new Long(mins  % 24).toString() + " minutes ago";
		if (mins  >=  1 )
			return new Long(mins ).toString() + " minutes " + new Long(mins  % 24).toString() + " seconds ago";
		else
			return new Long(secs ).toString() + " seconds ago";
	}
	
	public static String calcPrettyTime(java.sql.Timestamp time)
	{
		if (time  == null)
			return "-";
		return calcPrettyTime(System.currentTimeMillis() - time.getTime());
	}
}