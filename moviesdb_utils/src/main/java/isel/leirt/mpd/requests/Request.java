package isel.leirt.mpd.requests;

import java.io.Reader;

public interface Request {
	Reader getReader(String path);
}
