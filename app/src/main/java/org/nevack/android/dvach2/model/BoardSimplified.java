
package org.nevack.android.dvach2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BoardSimplified {

    @SerializedName("board")
    @Expose
    private String board;
    @SerializedName("threads")
    @Expose
    private List<ThreadSimplified> threads = null;

    /**
     * 
     * @return
     *     The board
     */
    public String getBoard() {
        return board;
    }

    /**
     * 
     * @param board
     *     The board
     */
    public void setBoard(String board) {
        this.board = board;
    }

    /**
     * 
     * @return
     *     The threads
     */
    public List<ThreadSimplified> getThreads() {
        return threads;
    }

    /**
     * 
     * @param threads
     *     The threads
     */
    public void setThreads(List<ThreadSimplified> threads) {
        this.threads = threads;
    }

}
