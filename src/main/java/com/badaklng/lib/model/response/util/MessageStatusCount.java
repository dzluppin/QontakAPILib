package com.badaklng.lib.model.response.util;

public class MessageStatusCount {
    private int failed;
    private int delivered;
    private int read;
    private int pending;
    private int sent;

    public MessageStatusCount() {}

    public int getFailed() { return failed; }
    public void setFailed(int failed) { this.failed = failed; }

    public int getDelivered() { return delivered; }
    public void setDelivered(int delivered) { this.delivered = delivered; }

    public int getRead() { return read; }
    public void setRead(int read) { this.read = read; }

    public int getPending() { return pending; }
    public void setPending(int pending) { this.pending = pending; }

    public int getSent() { return sent; }
    public void setSent(int sent) { this.sent = sent; }
}
