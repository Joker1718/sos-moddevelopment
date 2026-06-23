/*    */ package init.race.home;
/*    */ 
/*    */ import init.paths.PATHS;
/*    */ import init.type.HCLASS;
/*    */ import init.type.HCLASSES;
/*    */ import java.io.IOException;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.stats.Induvidual;
/*    */ import snake2d.util.file.Json;
/*    */ 
/*    */ 
/*    */ public final class RaceHome
/*    */ {
/*    */   private final RaceHomeClass DUMMY;
/* 15 */   private final RaceHomeClass[] all = new RaceHomeClass[HCLASSES.ALL().size()];
/*    */ 
/*    */ 
/*    */   
/*    */   public RaceHome(String key) throws IOException {
/* 20 */     Json json = new Json(PATHS.INIT().getFolder("race").getFolder("home").gets(key));
/* 21 */     this.DUMMY = new RaceHomeClass();
/* 22 */     for (int i = 0; i < this.all.length; i++)
/* 23 */       this.all[i] = this.DUMMY; 
/* 24 */     this.all[HCLASSES.CITIZEN().index()] = new RaceHomeClass(json.json((HCLASSES.CITIZEN()).key));
/* 25 */     this.all[HCLASSES.NOBLE().index()] = new RaceHomeClass(json.json((HCLASSES.NOBLE()).key));
/* 26 */     this.all[HCLASSES.SLAVE().index()] = new RaceHomeClass(json.json((HCLASSES.SLAVE()).key));
/*    */   }
/*    */   
/*    */   public RaceHomeClass clas(Humanoid h) {
/* 30 */     if (h == null)
/* 31 */       return this.DUMMY; 
/* 32 */     return this.all[h.indu().clas().index()];
/*    */   }
/*    */   
/*    */   public RaceHomeClass clas(Induvidual h) {
/* 36 */     return this.all[h.clas().index()];
/*    */   }
/*    */   
/*    */   public RaceHomeClass clas(HCLASS c) {
/* 40 */     return this.all[c.index()];
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\home\RaceHome.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */