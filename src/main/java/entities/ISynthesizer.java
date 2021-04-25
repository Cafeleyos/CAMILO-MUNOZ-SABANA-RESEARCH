package entities;

import java.time.Duration;
import java.util.HashMap;

public interface ISynthesizer {
  HashMap<String, Duration> synthesize(Project p) throws SabanaResearchException;

}