/*     */ package snake2d;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import java.util.Arrays;
/*     */ import snake2d.util.file.Alloc;
/*     */ 
/*     */ 
/*     */ final class VboSorter
/*     */ {
/*  10 */   private final Chunk[] chunks = new Chunk[256];
/*  11 */   private Chunk[] firstChunk = new Chunk[128];
/*  12 */   private Chunk[] currentChunk = new Chunk[128];
/*  13 */   private final Counts counts = new Counts();
/*     */   
/*     */   private final int[] data;
/*  16 */   private int chunkI = 0;
/*     */ 
/*     */   
/*     */   VboSorter(int size) {
/*  20 */     int MAX = size / this.chunks.length;
/*     */     
/*  22 */     for (int i = 0; i < this.chunks.length; i++) {
/*  23 */       this.chunks[i] = new Chunk(i * MAX, i * MAX + MAX);
/*     */     }
/*  25 */     this.data = Alloc.ii(size);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void add(int layer, int v) {
/*  31 */     if (this.chunkI >= this.chunks.length) {
/*     */       return;
/*     */     }
/*     */     
/*  35 */     Chunk c = this.currentChunk[layer];
/*  36 */     if (c == null) {
/*  37 */       c = this.chunks[this.chunkI];
/*  38 */       c.nextChunk = null;
/*  39 */       c.count = c.start;
/*  40 */       this.chunkI++;
/*  41 */       this.firstChunk[layer] = c;
/*  42 */       this.currentChunk[layer] = c;
/*     */     }
/*  44 */     else if (c.count >= c.max) {
/*  45 */       Chunk prev = c;
/*  46 */       c = this.chunks[this.chunkI];
/*  47 */       c.nextChunk = null;
/*  48 */       c.count = c.start;
/*  49 */       this.chunkI++;
/*  50 */       prev.nextChunk = c;
/*  51 */       this.currentChunk[layer] = c;
/*     */     } 
/*     */     
/*  54 */     this.data[c.count] = v;
/*  55 */     c.count++;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  60 */     Arrays.fill((Object[])this.currentChunk, (Object)null);
/*  61 */     Arrays.fill((Object[])this.firstChunk, (Object)null);
/*  62 */     this.chunkI = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public Counts fill(IntBuffer buff) {
/*  67 */     buff.position(0);
/*     */     
/*  69 */     for (int i = 0; i < this.firstChunk.length; i++) {
/*  70 */       Chunk c = this.firstChunk[i];
/*  71 */       if (c != null) {
/*  72 */         this.counts.from[i] = buff.position();
/*  73 */         while (c != null) {
/*  74 */           buff.put(this.data, c.start, c.count - c.start);
/*  75 */           c = c.nextChunk;
/*     */         } 
/*  77 */         this.counts.to[i] = buff.position();
/*     */       } else {
/*     */         
/*  80 */         this.counts.from[i] = 0;
/*  81 */         this.counts.to[i] = 0;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  86 */     clear();
/*  87 */     return this.counts;
/*     */   }
/*     */   
/*     */   private static final class Chunk
/*     */   {
/*     */     final int start;
/*     */     final int max;
/*     */     int count;
/*     */     Chunk nextChunk;
/*     */     
/*     */     Chunk(int start, int max) {
/*  98 */       this.start = start;
/*  99 */       this.max = max;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Counts
/*     */   {
/* 106 */     public final int[] from = Alloc.ii(128);
/* 107 */     public final int[] to = Alloc.ii(128);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\VboSorter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */