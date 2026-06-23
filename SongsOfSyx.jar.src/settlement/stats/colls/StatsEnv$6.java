/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STATFakeData;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
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
/* 159 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   protected double getDD(HCLASS cl, Race race) {
/* 163 */     double d = 0.0D;
/* 164 */     double tot = 0.0D;
/* 165 */     for (Race r : RACES.all()) {
/* 166 */       tot += 1.0D - race.pref().race(r);
/* 167 */       d += (1.0D - race.pref().race(r)) * (SETT.ROOMS()).CANNIBAL.cannibalism(r);
/*     */     } 
/* 169 */     return CLAMP.d(d / tot, 0.0D, 1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX text, HCLASS cl, Race type) {
/* 174 */     if (type != null) {
/* 175 */       GBox b = (GBox)text;
/*     */       
/* 177 */       b.textLL(RACES.name());
/* 178 */       b.tab(5);
/* 179 */       b.textLL(StatsEnv.¤¤pref);
/* 180 */       b.tab(10);
/* 181 */       b.textLL((StatsEnv.this.CANNIBALISM.info()).name);
/* 182 */       b.NL();
/*     */       
/* 184 */       for (Race r : RACES.all()) {
/* 185 */         b.add((SPRITE)(r.appearance()).icon);
/* 186 */         b.text(r.info.names);
/* 187 */         b.tab(5);
/* 188 */         b.add((SPRITE)GFORMAT.perc(b.text(), 1.0D - type.pref().race(r)));
/* 189 */         b.tab(10);
/* 190 */         b.add((SPRITE)GFORMAT.perc(b.text(), (SETT.ROOMS()).CANNIBAL.cannibalism(r)));
/* 191 */         b.NL();
/*     */       } 
/*     */     } 
/*     */     
/* 195 */     super.hover(text, cl, type);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsEnv$6.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */