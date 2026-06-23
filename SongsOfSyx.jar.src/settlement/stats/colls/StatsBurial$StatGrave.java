/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import settlement.room.spirit.grave.GraveData;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.standing.StatStanding;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATFakeData;
/*     */ import settlement.stats.stat.StatInfo;
/*     */ import settlement.stats.util.StatHoverer;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.keymap.MAPPED;
/*     */ import util.keymap.RMapInt;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StatGrave
/*     */   extends STATFakeData
/*     */ {
/*     */   private GraveData h;
/* 154 */   private RMapInt.RMapIntTwo<HCLASS, Race> access = new RMapInt.RMapIntTwo(HCLASSES.MAP(), RACES.map());
/*     */   
/*     */   StatGrave(GraveData h, StatsInit init, StatInfo info) {
/* 157 */     super((h.blueprint()).key, "BURR_" + (h.blueprint()).key, init, info);
/* 158 */     this.standing = new StatStanding((STAT)this, 0.0D, h.standingDef());
/* 159 */     this.h = h;
/*     */ 
/*     */     
/* 162 */     init.savers.put("BURR_ACCESS_" + (h.blueprint()).key, this.access);
/* 163 */     (info()).icon = (h.blueprint()).icon.resized(16);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected double getDD(HCLASS cl, Race r) {
/* 169 */     return this.access.get((MAPPED)cl).getD(r) * (this.h.get(cl)).value.getD(r);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public GraveData grave() {
/* 175 */     return this.h;
/*     */   }
/*     */   
/*     */   int gIndex() {
/* 179 */     return index() - ((StatGrave)(STATS.BURIAL()).graves.get(0)).index();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX text, HCLASS cl, Race type) {
/* 185 */     GBox b = (GBox)text;
/* 186 */     b.title((info()).name);
/* 187 */     GraveData da = grave();
/*     */     
/* 189 */     b.textLL(Dic.¤¤Access);
/* 190 */     b.add((SPRITE)GFORMAT.perc(b.text(), this.access.get((MAPPED)cl).getD(type)));
/*     */ 
/*     */     
/* 193 */     b.textLL((da.respect.info()).name);
/* 194 */     b.add((SPRITE)GFORMAT.perc(b.text(), da.respect.getD(null)));
/* 195 */     b.NL().text((da.respect.info()).desc);
/* 196 */     b.NL(4);
/* 197 */     b.textLL(((da.get(cl)).burried.info()).name);
/* 198 */     b.add((SPRITE)GFORMAT.iofkInv(b.text(), (int)(da.get(cl)).burried.getD(type), ((int)(da.get(cl)).burried.getD(type) + (int)(da.get(cl)).failed.getD(type))));
/*     */     
/* 200 */     b.NL().text(((da.get(cl)).burried.info()).desc);
/* 201 */     b.sep();
/* 202 */     StatHoverer.hover(text, (STAT)this, cl, type);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX text, Induvidual indu) {
/* 207 */     hover(text, indu.clas(), indu.race());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsBurial$StatGrave.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */