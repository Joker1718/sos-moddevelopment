/*     */ package settlement.job;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.environment.SettEnvMap;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.stats.standing.STANDINGS;
/*     */ import settlement.tilemap.floor.Floors;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
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
/*     */   extends Placer
/*     */ {
/*     */   null(Job $anonymous0, RESOURCE $anonymous1, int $anonymous2, CharSequence $anonymous3) {
/* 139 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*     */ 
/*     */     
/* 142 */     paramLinkedList.add((Iterable)this.bOverwrite);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverDesc(GBox box) {
/* 147 */     super.hoverDesc(box);
/* 148 */     box.NL(4);
/*     */     
/* 150 */     box.textL(((STANDINGS.CITIZEN()).fullfillment.info()).name);
/* 151 */     box.NL();
/* 152 */     int ta = 0;
/* 153 */     for (Race race : RACES.all()) {
/*     */       
/* 155 */       box.add((race.appearance()).icon.medium);
/* 156 */       box.add((SPRITE)GFORMAT.perc(box.text(), floor.pref(race)));
/* 157 */       box.space();
/* 158 */       if (ta++ > 4) {
/* 159 */         box.NL();
/* 160 */         ta = 0;
/*     */       } 
/*     */     } 
/*     */     
/* 164 */     box.NL(8);
/*     */     
/* 166 */     box.textL(Dic.¤¤Speed);
/* 167 */     box.tab(5);
/* 168 */     box.add((SPRITE)GFORMAT.percInc(box.text(), floor.speed.movementSpeed - AVAILABILITY.NORMAL.movementSpeed));
/* 169 */     box.NL();
/*     */     
/* 171 */     for (SettEnvMap.SettEnv e : (SETT.ENV()).map.all()) {
/* 172 */       if (floor.envValue(e) != 0.0D) {
/* 173 */         box.textL(e.info.name);
/* 174 */         box.tab(5);
/* 175 */         box.add((SPRITE)GFORMAT.perc(box.text(), floor.envValue(e)));
/* 176 */         box.NL();
/*     */       } 
/*     */     } 
/* 179 */     box.NL();
/* 180 */     box.textL(JobBuildRoad.¤¤durability);
/* 181 */     box.tab(5);
/* 182 */     box.add((SPRITE)GFORMAT.perc(box.text(), floor.durability));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<CLICKABLE> getAdditionalButt() {
/* 188 */     return (LIST<CLICKABLE>)bs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JobBuildRoad$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */