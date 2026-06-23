/*    */ package game.faction.npc;
/*    */ 
/*    */ import game.faction.royalty.opinion.ROPINION;
/*    */ import game.time.TIME;
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import util.Debugger;
/*    */ 
/*    */ public final class NPCRequest
/*    */   implements Debugger.Debuggable
/*    */ {
/*    */   private boolean has = false;
/* 14 */   private double time = 0.0D;
/* 15 */   private double penalty = 0.0D;
/*    */   private final FactionNPC f;
/* 17 */   private CharSequence key = "";
/*    */   
/*    */   NPCRequest(FactionNPC fa) {
/* 20 */     this.f = fa;
/*    */   }
/*    */   
/*    */   public boolean has() {
/* 24 */     return this.has;
/*    */   }
/*    */   
/*    */   public void set(double penalty, CharSequence key) {
/* 28 */     this.time = TIME.currentSecond();
/* 29 */     this.penalty = penalty;
/* 30 */     this.has = true;
/* 31 */     this.key = key;
/*    */   }
/*    */   
/*    */   public void clear() {
/* 35 */     this.has = false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void expire() {
/* 40 */     if (this.has) {
/* 41 */       this.has = false;
/*    */       
/* 43 */       ROPINION.GIFTS().makeDeal(this.f, this.penalty);
/*    */     } 
/*    */   }
/*    */   
/*    */   void update() {
/* 48 */     if ((this.has & ((Math.abs(TIME.currentSecond() - this.time) > TIME.secondsPerDay()) ? 1 : 0)) != 0) {
/* 49 */       expire();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   void save(FilePutter file) {
/* 55 */     file.bool(this.has);
/* 56 */     file.d(this.time);
/* 57 */     file.d(this.penalty);
/* 58 */     file.chars(this.key);
/*    */   }
/*    */   
/*    */   void load(FileGetter file) throws IOException {
/* 62 */     this.has = file.bool();
/* 63 */     this.time = file.d();
/* 64 */     this.penalty = file.d();
/* 65 */     this.key = file.chars();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\npc\NPCRequest.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */