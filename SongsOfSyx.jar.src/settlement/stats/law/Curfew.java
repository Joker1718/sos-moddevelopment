/*    */ package settlement.stats.law;
/*    */ 
/*    */ import game.time.TIME;
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ import util.text.D;
/*    */ 
/*    */ 
/*    */ public final class Curfew
/*    */ {
/* 13 */   public static CharSequence ¤¤name = "¤Curfew";
/* 14 */   public static CharSequence ¤¤desc = "¤When a curfew is active, subjects will not visit their ordinary jobs, and stay home or inside, except when they need to visit basic services. This deters criminals, and prevents disease from being spread.";
/*    */   
/*    */   static {
/* 17 */     D.ts(Curfew.class);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private double timer;
/*    */ 
/*    */ 
/*    */   
/*    */   void update(double ds) {
/* 27 */     if (this.timer > 0.0D)
/* 28 */       this.timer -= ds; 
/*    */   }
/*    */   
/*    */   public boolean is() {
/* 32 */     return (this.timer > 0.0D);
/*    */   }
/*    */   
/*    */   public boolean isSetForADay() {
/* 36 */     return (this.timer > 0.0D);
/*    */   }
/*    */   
/*    */   public void setForADay(boolean set) {
/* 40 */     if (set) {
/* 41 */       this.timer = TIME.secondsPerDay();
/*    */     } else {
/* 43 */       this.timer = 0.0D;
/*    */     } 
/*    */   }
/* 46 */   final SAVABLE saver = new SAVABLE()
/*    */     {
/*    */       public void save(FilePutter file)
/*    */       {
/* 50 */         file.d(Curfew.this.timer);
/*    */       }
/*    */ 
/*    */       
/*    */       public void load(FileGetter file) throws IOException {
/* 55 */         Curfew.this.timer = file.d();
/*    */       }
/*    */ 
/*    */       
/*    */       public void clear() {
/* 60 */         Curfew.this.timer = 0.0D;
/*    */       }
/*    */     };
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\law\Curfew.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */