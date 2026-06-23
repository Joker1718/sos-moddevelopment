/*    */ package world.army;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.VERSION;
/*    */ import init.race.Race;
/*    */ import java.io.IOException;
/*    */ import java.nio.file.Path;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import snake2d.util.sets.ArrayListIntegerResize;
/*    */ import snake2d.util.sets.ArrayListResize;
/*    */ import world.entity.army.WArmy;
/*    */ 
/*    */ public final class WDivRegionalAll
/*    */   implements SAVABLE
/*    */ {
/*    */   static final int type = 0;
/* 20 */   private final ArrayListResize<WDivRegional> all = new ArrayListResize(4096, 1048576);
/* 21 */   private final ArrayListIntegerResize free = new ArrayListIntegerResize(4096, 1048576);
/*    */   
/*    */   WDivRegionalAll() {
/* 24 */     GAME.saver().onAfterLoad(new ACTION.ACTION_O<Path>()
/*    */         {
/*    */           public void exe(Path t)
/*    */           {
/* 28 */             if (VERSION.versionIsBefore(70, 23))
/* 29 */               for (WDivRegional rr : WDivRegionalAll.this.all) {
/* 30 */                 if (rr.army() != null) {
/* 31 */                   rr.menSet(rr.men());
/*    */                 }
/*    */               }  
/*    */           }
/*    */         });
/*    */   }
/*    */   
/*    */   private int create() {
/* 39 */     if (this.free.isEmpty()) {
/* 40 */       WDivRegional div = new WDivRegional(this.all.size());
/* 41 */       this.all.add(div);
/* 42 */       return div.index;
/*    */     } 
/* 44 */     int i = this.free.get(this.free.size() - 1);
/* 45 */     this.free.remove(this.free.size() - 1);
/* 46 */     return i;
/*    */   }
/*    */ 
/*    */   
/*    */   public WDivRegional create(Race race, double amount, WArmy a) {
/* 51 */     int i = create();
/* 52 */     get(i).init(race, amount, a);
/* 53 */     return get(i);
/*    */   }
/*    */ 
/*    */   
/*    */   WDivRegional get(int index) {
/* 58 */     return (WDivRegional)this.all.get(index);
/*    */   }
/*    */   
/*    */   void retire(WDivRegional div) {
/* 62 */     this.free.add(div.index);
/*    */   }
/*    */ 
/*    */   
/*    */   public void save(FilePutter file) {
/* 67 */     file.i(this.all.size());
/* 68 */     for (WDivRegional r : this.all) {
/* 69 */       r.save(file);
/*    */     }
/* 71 */     this.free.save(file);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 77 */     int am = file.i();
/* 78 */     this.all.clear();
/* 79 */     this.free.clear();
/* 80 */     for (int i = 0; i < am; i++) {
/* 81 */       int k = create();
/* 82 */       get(k).load(file);
/*    */     } 
/* 84 */     this.free.load(file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 89 */     this.all.clear();
/* 90 */     this.free.clear();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\WDivRegionalAll.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */