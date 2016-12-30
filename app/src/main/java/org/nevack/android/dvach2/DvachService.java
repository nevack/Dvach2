package org.nevack.android.dvach2;

import org.nevack.android.dvach2.model.Board;
import org.nevack.android.dvach2.model.BoardConfig;
import org.nevack.android.dvach2.model.BoardSimplified;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DvachService {
    @GET("makaba/mobile.fcgi?task=get_boards")
    Call<Map<String, List<BoardConfig>>> getBoardConfig();

    @GET("{board}/threads.json")
    Call<BoardSimplified> getSimplifiedCatalog(@Path("board") String boardCode);


    @GET("{board}/res/{num}.json")
    Call<Board> getThread(@Path("board") String boardCode, @Path("num") int threadNum);
}
