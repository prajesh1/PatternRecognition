import java.util.ArrayList;
import java.util.List;

public class BruteCollinearPoints {
	private List<LineSegment> lineSegments = new ArrayList<LineSegment>();
   public BruteCollinearPoints(Point[] points)    // finds all line segments containing 4 points
   {
	  for(int i=0;i<points.length;i++)
	   {
		   for(int j=i+1;i<points.length;j++)
		   {
			   double firstSlope = points[i].slopeTo(points[j]);
			   int count =2;
			   for(int k=j+1;j<points.length;k++)
			   {
				   if(firstSlope==points[j].slopeTo(points[k]))
				   {
					   count = count+1;
					   if(count==4)
					   {
						   LineSegment lineSegment = new LineSegment(points[i],points[k]);
						   lineSegments.add(lineSegment);
					   }
				   }
			   }
		   }
	   }
   }
   public           int numberOfSegments()        // the number of line segments
   {
	   return lineSegments.size();
   }
   public LineSegment[] segments()                // the line segments
   {
	   return (LineSegment[])lineSegments.toArray();
   }
}