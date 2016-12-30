package org.nevack.android.dvach2;

import org.nevack.android.dvach2.model.Board;
import org.nevack.android.dvach2.model.BoardConfig;
import org.nevack.android.dvach2.model.BoardSettings;
import org.nevack.android.dvach2.model.BoardSimplified;
import org.nevack.android.dvach2.model.Captcha;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DvachService {
    @GET("makaba/mobile.fcgi?task=get_boards")
    Call<Map<String, List<BoardConfig>>> getBoardConfig();

    @GET("{board}/threads.json")
    Call<BoardSimplified> getSimplifiedCatalog(@Path("board") String boardCode);


    @GET("{board}/res/{num}.json")
    Call<Board> getThread(@Path("board") String boardCode, @Path("num") int threadNum);

    @GET("api/captcha/settings/{board}")
    Call<BoardSettings> getBoardSettings(@Path("board") String boardCode);

    @GET("api/captcha/{type}/id")
    Call<Captcha> getCaptcha(@Path("type") String captchaType,
                             @Query("board") String boardCode,
                             @Query("thread") String threadNum);
}
