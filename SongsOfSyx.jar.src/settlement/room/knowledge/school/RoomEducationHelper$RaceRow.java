/*     */ package settlement.room.knowledge.school;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.Boostable;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsEducation;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GSliderInt;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class RaceRow
/*     */   extends GuiSection
/*     */ {
/*     */   RaceRow(final HCLASS_RACE race, final Boostable bonus, final StatsEducation.AgeType type) {
/* 184 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 187 */           GBox b = (GBox)text;
/*     */           
/* 189 */           b.textLL(race.race.info.names);
/* 190 */           b.textL(race.cl.names);
/* 191 */           b.NL();
/*     */           
/* 193 */           type.hoverLimit(text, race);
/* 194 */           b.NL(8);
/*     */           
/* 196 */           b.textLL(RoomEducationHelper.¤¤boost);
/* 197 */           b.tab(6);
/* 198 */           double am = race.race.bvalue(bonus);
/* 199 */           b.add((SPRITE)GFORMAT.f(b.text(), am));
/* 200 */           b.NL();
/*     */           
/* 202 */           b.textLL(RoomEducationHelper.¤¤daysToEducate);
/* 203 */           b.tab(6);
/* 204 */           am = type.limit(race) / bonus.get((BOOSTABLE_O)race) * type.limitSpeed(race);
/* 205 */           b.add((SPRITE)GFORMAT.f(b.text(), am));
/* 206 */           b.NL();
/*     */         }
/*     */       };
/*     */     
/* 210 */     s.addRightC(0, (SPRITE)(race.race.appearance()).icon);
/* 211 */     s.addRightC(-8, (SPRITE)race.cl.iconSmall());
/* 212 */     s.addRightC(4, (SPRITE)new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 216 */             GFORMAT.i(text, (long)Math.ceil(type.limit(race) / bonus.get((BOOSTABLE_O)race) * type.limitSpeed(race)));
/*     */           }
/*     */         });
/*     */     
/* 220 */     INT.INTE ii = new INT.INTE()
/*     */       {
/*     */         public int min()
/*     */         {
/* 224 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 229 */           return 100;
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 234 */           return type.limit(race);
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 239 */           type.limitSet(race, t);
/*     */         }
/*     */       };
/*     */     
/* 243 */     s.addRightC(60, (RENDEROBJ)new GSliderInt(ii, 120, true, false));
/* 244 */     add((RENDEROBJ)s);
/* 245 */     body().incrW(16.0D);
/*     */     
/* 247 */     for (StatsEducation.StatEducation ss : (STATS.EDUCATION()).all) {
/* 248 */       addRightC(8, (RENDEROBJ)new GButt.ButtPanel((ss.total.info()).icon.resized(16))
/*     */           {
/*     */             protected void renAction()
/*     */             {
/* 252 */               selectedSet((STATS.EDUCATION().policy(race) == ss));
/*     */             }
/*     */ 
/*     */             
/*     */             protected void clickA() {
/* 257 */               STATS.EDUCATION().policySet(race, ss);
/*     */             }
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GUI_BOX text) {
/* 262 */               ss.total.hover(text, race.cl, race.race);
/*     */             }
/*     */           });
/*     */     } 
/*     */     
/* 267 */     pad(4, 1);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledge\school\RoomEducationHelper$RaceRow.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */