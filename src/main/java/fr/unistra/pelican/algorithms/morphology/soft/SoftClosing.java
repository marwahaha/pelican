package fr.unistra.pelican.algorithms.morphology.soft;




import fr.unistra.pelican.Algorithm;
import fr.unistra.pelican.AlgorithmException;
import fr.unistra.pelican.Image;
import fr.unistra.pelican.util.morphology.GrayIntStructuringElement;


/**
 * Perform a soft closing with a Gray Int structuring element.
 * 
 * @author Benjamin Perret
 */
public class SoftClosing extends Algorithm {
	/**
	 * Input image
	 */
	private Image inputImage;
	
	/**
	 * Rank Order
	 */
	private int seuil;
	
	/**
	 * Flat Structuring Element and weight map
	 */
	private GrayIntStructuringElement se;

	/**
	 * Output image
	 */
	private Image outputImage;


	/**
	 * Default constructor
	 */
	public SoftClosing()
	{
		super.inputs="inputImage,se,seuil";
		super.outputs="outputImage";
	}
	
	/* (non-Javadoc)
	 * @see fr.unistra.pelican.Algorithm#launch()
	 */
	public void launch() throws AlgorithmException {
		outputImage = SoftDilation.exec(inputImage, se, seuil);
		outputImage = SoftErosion.exec(outputImage, se, seuil);
		
	}

	/**
	 * Perform a soft closing with a Gray Int structuring element.
	 *  
	 * @param image Input image
	 * @param se Flat Structuring Element and weight map
	 * @param threshold Rank Order
	 * @return Result
	 */
	public static Image exec(Image image, GrayIntStructuringElement se, int threshold)
	{
		return (Image) (new SoftClosing()).process(image,se,threshold);
	}
}