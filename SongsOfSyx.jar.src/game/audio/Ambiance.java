/*    */ package game.audio;
/*    */ 
/*    */ import snake2d.SoundStream;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import util.keymap.MAPPED;
/*    */ 
/*    */ 
/*    */ public final class Ambiance
/*    */   implements MAPPED
/*    */ {
/*    */   AmbianceUpdater.Channel channel;
/*    */   public final LIST<SoundStream> streams;
/*    */   double priority;
/*    */   private double gain;
/*    */   private final String key;
/*    */   private final int index;
/*    */   
/*    */   Ambiance(String key, LISTE<Ambiance> all, LIST<SoundStream> streams) {
/* 20 */     this.streams = streams;
/* 21 */     this.index = all.add(this);
/* 22 */     this.key = key;
/*    */   }
/*    */   
/*    */   public double gain() {
/* 26 */     return this.gain;
/*    */   }
/*    */   
/*    */   public Ambiance gainSet(double gain) {
/* 30 */     this.gain = gain;
/* 31 */     return this;
/*    */   }
/*    */   
/*    */   public double priority() {
/* 35 */     return this.priority;
/*    */   }
/*    */   
/*    */   public Ambiance prioritySet(double priority) {
/* 39 */     this.priority = priority;
/* 40 */     return this;
/*    */   }
/*    */   
/*    */   public Ambiance priorityInc(double priority) {
/* 44 */     this.priority += priority;
/* 45 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int index() {
/* 64 */     return this.index;
/*    */   }
/*    */ 
/*    */   
/*    */   public String key() {
/* 69 */     return this.key;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\audio\Ambiance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */