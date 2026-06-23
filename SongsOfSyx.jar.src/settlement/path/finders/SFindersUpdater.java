/*    */ package settlement.path.finders;
/*    */ 
/*    */ import game.time.TIME;
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ import util.updating.IUpdater;
/*    */ 
/*    */ 
/*    */ public class SFindersUpdater
/*    */ {
/*    */   private final IUpdater upper;
/*    */   public static final int quad = 16;
/* 16 */   static final int W = SETT.TWIDTH / 16;
/* 17 */   static final int H = SETT.THEIGHT / 16;
/*    */ 
/*    */   
/*    */   public SFindersUpdater() {
/* 21 */     int am = SFinderFindableMap.W * SFinderFindableMap.H;
/*    */     
/* 23 */     this.upper = new IUpdater(am, TIME.days().bitSeconds() * 2.0D)
/*    */       {
/*    */         protected void update(int i, double timeSinceLast)
/*    */         {
/* 27 */           boolean d = ((TIME.days().bitsSinceStart() & 0x1) == 1);
/* 28 */           for (SFinderFindable a : SFinderFindable.all) {
/* 29 */             a.map.update(i, d);
/*    */           }
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   public void update(double ds) {
/* 36 */     this.upper.update(ds);
/*    */   }
/*    */   
/* 39 */   public final SAVABLE saver = new SAVABLE()
/*    */     {
/*    */       public void save(FilePutter file)
/*    */       {
/* 43 */         file.i(SFinderFindable.all.size());
/* 44 */         for (SFinderFindable a : SFinderFindable.all) {
/* 45 */           a.map.save(file);
/*    */         }
/*    */       }
/*    */ 
/*    */ 
/*    */       
/*    */       public void load(FileGetter file) throws IOException {
/* 52 */         int am = file.i();
/* 53 */         if (am != SFinderFindable.all.size()) {
/* 54 */           for (int i = 0; i < am; i++) {
/* 55 */             ((SFinderFindable)SFinderFindable.all.get(0)).map.load(file);
/*    */           }
/* 57 */           clear();
/*    */         } else {
/*    */           
/* 60 */           for (SFinderFindable a : SFinderFindable.all) {
/* 61 */             a.map.load(file);
/*    */           }
/*    */         } 
/*    */       }
/*    */ 
/*    */       
/*    */       public void clear() {
/* 68 */         for (int i = 0; i < SFinderFindable.all.size(); i++)
/* 69 */           ((SFinderFindable)SFinderFindable.all.get(i)).map.clear(); 
/*    */       }
/*    */     };
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFindersUpdater.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */