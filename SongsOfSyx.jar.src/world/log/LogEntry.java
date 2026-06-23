/*    */ package world.log;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.FBanner;
/*    */ import init.sprite.UI.Icon;
/*    */ import init.sprite.UI.UI;
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ 
/*    */ 
/*    */ public class LogEntry
/*    */ {
/* 15 */   short ii = -1;
/* 16 */   short fa = -1;
/* 17 */   short fb = -1;
/*    */   short tx;
/*    */   short ty;
/*    */   int day;
/* 21 */   public Str message = new Str(64);
/*    */ 
/*    */   
/*    */   LogEntry() {}
/*    */ 
/*    */   
/*    */   LogEntry(FileGetter file) throws IOException {
/* 28 */     this.ii = file.s();
/* 29 */     this.fa = file.s();
/* 30 */     this.fb = file.s();
/* 31 */     this.tx = file.s();
/* 32 */     this.ty = file.s();
/* 33 */     this.day = file.i();
/* 34 */     this.message.load(file);
/*    */   }
/*    */   
/*    */   public FBanner bannerA() {
/* 38 */     if (this.fa >= 0)
/* 39 */       return FACTIONS.getByIndex(this.fa).banner(); 
/* 40 */     return null;
/*    */   }
/*    */   
/*    */   public FBanner bannerB() {
/* 44 */     if (this.fb >= 0)
/* 45 */       return FACTIONS.getByIndex(this.fb).banner(); 
/* 46 */     return null;
/*    */   }
/*    */   
/*    */   public int daySinceStart() {
/* 50 */     return this.day;
/*    */   }
/*    */   
/*    */   public Icon icon() {
/* 54 */     return (Icon)(UI.icons()).s.get(this.ii);
/*    */   }
/*    */   
/*    */   public int tx() {
/* 58 */     return this.tx;
/*    */   }
/*    */   
/*    */   public int ty() {
/* 62 */     return this.ty;
/*    */   }
/*    */   
/*    */   void save(FilePutter file) {
/* 66 */     file.s(this.ii);
/* 67 */     file.s(this.fa);
/* 68 */     file.s(this.fb);
/* 69 */     file.s(this.tx);
/* 70 */     file.s(this.ty);
/* 71 */     file.i(this.day);
/* 72 */     this.message.save(file);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\log\LogEntry.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */