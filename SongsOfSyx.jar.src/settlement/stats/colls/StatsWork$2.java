/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import init.type.HTYPES;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STATFakeData;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends STATFakeData
/*     */ {
/*     */   null(String $anonymous0, StatsInit $anonymous1) {
/* 118 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   protected double getDD(HCLASS cl, Race race) {
/* 122 */     double v = CLAMP.d(d(cl, race), 0.0D, 1.0D);
/* 123 */     return v;
/*     */   }
/*     */   
/*     */   private double d(HCLASS cl, Race race) {
/* 127 */     double v = StatsWork.this.fvalues[(HCLASS_RACE.clP(race, cl)).index] / 256.0D;
/* 128 */     double pop = 0.0D;
/* 129 */     if (cl == HCLASSES.SLAVE()) {
/* 130 */       pop = STATS.POP().pop(race, HTYPES.SLAVE());
/*     */     } else {
/* 132 */       pop = (STATS.POP().pop(race, HTYPES.STUDENT()) + STATS.POP().pop(race, HTYPES.RECRUIT()) + STATS.POP().pop(race, HTYPES.SUBJECT()) + STATS.POP().pop(race, HTYPES.GUARD()));
/* 133 */     }  if (pop > 0.0D) {
/* 134 */       return v / pop;
/*     */     }
/* 136 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   protected double indu(Induvidual t) {
/* 141 */     RoomInstance ins = (RoomInstance)StatsWork.this.EMPLOYED.get(t);
/* 142 */     if (ins != null) {
/* 143 */       return t.race().pref().getWork(ins.blueprintI().employment());
/*     */     }
/* 145 */     return 0.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX text, HCLASS cl, Race type) {
/* 151 */     GBox b = (GBox)text;
/*     */     
/* 153 */     b.textLL(Dic.¤¤BaseValue);
/* 154 */     b.tab(16);
/* 155 */     b.add((SPRITE)GFORMAT.perc(b.text(), d(cl, type)));
/* 156 */     b.NL();
/*     */     
/* 158 */     super.hover(text, cl, type);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsWork$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */