/*    */ package settlement.stats.service;
/*    */ 
/*    */ import init.race.Race;
/*    */ import init.type.HCLASS;
/*    */ import init.type.HCLASS_RACE;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.health.hospital.ROOM_HOSPITAL;
/*    */ import settlement.stats.Induvidual;
/*    */ import settlement.stats.POP;
/*    */ import settlement.stats.StatsInit;
/*    */ import settlement.stats.stat.STAT;
/*    */ import settlement.stats.stat.STATFakeData;
/*    */ import settlement.stats.stat.StatInfo;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ import util.info.GFORMAT;
/*    */ import util.text.Dic;
/*    */ 
/*    */ public final class StatServiceHospital extends StatServiceImp {
/*    */   private final STAT stat;
/*    */   
/*    */   StatServiceHospital(LISTE<StatServiceImp> all, ROOM_HOSPITAL ho, StatsInit init) {
/* 27 */     super(ho.key, all, init, ho.info.name, ho.info.desc, (SPRITE)ho.icon, null);
/* 28 */     this.stat = (STAT)new STATFakeData(ho.key, ho.key + "D", init, new StatInfo(ho.info.name, ho.info.desc))
/*    */       {
/*    */         public void hover(GUI_BOX text, HCLASS cl, Race type)
/*    */         {
/* 32 */           GBox b = (GBox)text;
/* 33 */           b.textLL(((SETT.ROOMS()).HOSPITAL.employment()).title);
/* 34 */           b.NL();
/* 35 */           b.textL(Dic.¤¤Employees);
/* 36 */           b.tab(6);
/* 37 */           b.add((SPRITE)GFORMAT.i(b.text(), (SETT.ROOMS()).HOSPITAL.employment().employed()));
/* 38 */           b.NL();
/* 39 */           b.textL(Dic.¤¤Target);
/* 40 */           b.tab(6);
/* 41 */           b.add((SPRITE)GFORMAT.i(b.text(), (int)Math.ceil((POP.tot(null, null) + 1) / 75.0D)));
/* 42 */           b.NL();
/* 43 */           b.textL(Dic.¤¤Access);
/* 44 */           b.tab(6);
/* 45 */           b.add((SPRITE)GFORMAT.bool(b.text(), StatServiceHospital.this.permission().is(HCLASS_RACE.clP(type, cl))));
/* 46 */           b.NL();
/* 47 */           b.textL(Dic.¤¤Value);
/* 48 */           b.tab(6);
/* 49 */           b.add((SPRITE)GFORMAT.perc(b.text(), CLAMP.d(100.0D * (SETT.ROOMS()).HOSPITAL.employment().employed() / (POP.tot(null, null) + 1), 0.0D, 1.0D)));
/* 50 */           b.NL();
/*    */           
/* 52 */           super.hover(text, cl, type);
/*    */         }
/*    */ 
/*    */         
/*    */         public void hover(GUI_BOX text, Induvidual indu) {
/* 57 */           hover(text, indu.clas(), indu.race());
/*    */         }
/*    */ 
/*    */         
/*    */         protected double getDD(HCLASS cl, Race r) {
/* 62 */           if (!StatServiceHospital.this.permission().is(HCLASS_RACE.clP(r, cl)))
/* 63 */             return 0.0D; 
/* 64 */           double e = (SETT.ROOMS()).HOSPITAL.employment().employed();
/* 65 */           return 75.0D * e / (1.0D + POP.tot(null, null));
/*    */         }
/*    */       };
/* 68 */     (this.stat.info()).icon = (SETT.ROOMS()).HOSPITAL.icon.resized(16);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean access(Humanoid h) {
/* 74 */     return (this.stat.indu().getD(h.indu()) >= 1.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   public STAT total() {
/* 79 */     return this.stat;
/*    */   }
/*    */   
/*    */   public void clearAccess(Induvidual i) {}
/*    */   
/*    */   public void cheatSetTotal(Induvidual i, double tot) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\service\StatServiceHospital.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */