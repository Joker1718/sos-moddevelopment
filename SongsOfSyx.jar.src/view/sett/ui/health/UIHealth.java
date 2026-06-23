/*     */ package view.sett.ui.health;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.Booster;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.DISEASE;
/*     */ import init.type.DISEASES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.util.Comparator;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.stat.STAT;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.gui.table.GStaples;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.DicTime;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ public class UIHealth extends ISidePanel {
/*  42 */   private static CharSequence ¤¤Diseases = "Known Diseases";
/*  43 */   private static CharSequence ¤¤Epidemic = "Current Epidemic";
/*     */   
/*     */   static {
/*  46 */     D.ts(UIHealth.class);
/*     */   }
/*     */   
/*     */   public UIHealth() {
/*  50 */     final Boostable bo = (BOOSTABLES.PHYSICS()).HEALTH;
/*  51 */     titleSet(bo.name);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  58 */     this.section.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  62 */             if (STATS.DISEASE().currentEpidemic() == null) {
/*  63 */               text.add('-').add('-').add('-');
/*     */             } else {
/*  65 */               text.add((STATS.DISEASE().currentEpidemic()).info.name);
/*     */             } 
/*     */           }
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/*  70 */             if (STATS.DISEASE().currentEpidemic() != null) {
/*  71 */               STATS.DISEASE().currentEpidemic().hover((GUI_BOX)b);
/*     */             }
/*     */           }
/*  74 */         }).increase().hv(¤¤Epidemic));
/*     */     
/*  76 */     GuiSection guiSection1 = new GuiSection();
/*     */     
/*  78 */     if ((S.get()).developer)
/*  79 */       guiSection1.add(stat(STATS.DISEASE().incubating()), 0, guiSection1.body().y2() + 6); 
/*  80 */     guiSection1.add(stat(STATS.DISEASE().sick()), 0, guiSection1.body().y2() + 6);
/*     */ 
/*     */ 
/*     */     
/*  84 */     guiSection1.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  88 */             GFORMAT.iofk(text, (SETT.ROOMS()).HOSPITAL.service().available(), (SETT.ROOMS()).HOSPITAL.service().total());
/*     */           }
/*  91 */         }).increase().hh((SETT.ROOMS()).HOSPITAL.info.names, 250), 0, guiSection1.body().y2() + 6);
/*     */     
/*  93 */     guiSection1.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  97 */             GFORMAT.f1(text, bo.get((BOOSTABLE_O)HCLASS_RACE.clP()));
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 102 */             bo.hoverDetailed((GUI_BOX)b, (BOOSTABLE_O)HCLASS_RACE.clP(), null, true);
/*     */           }
/* 105 */         }).increase().hh(bo.name, 250), 0, guiSection1.body().y2() + 6);
/*     */ 
/*     */ 
/*     */     
/* 109 */     this.section.addRelBody(8, DIR.S, (RENDEROBJ)guiSection1);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 114 */     double m = 0.0D;
/* 115 */     for (Booster b : (BOOSTABLES.PHYSICS()).HEALTH.all())
/*     */     {
/* 117 */       m = Math.max(m, b.max());
/*     */     }
/*     */     
/* 120 */     ArrayList<RENDEROBJ> arrayList = new ArrayList((BOOSTABLES.PHYSICS()).HEALTH.all().size());
/*     */ 
/*     */     
/* 123 */     ArrayList<Booster> bb = new ArrayList((Iterable)(BOOSTABLES.PHYSICS()).HEALTH.all());
/* 124 */     bb.sort(new Comparator<Booster>()
/*     */         {
/*     */           public int compare(Booster o1, Booster o2)
/*     */           {
/* 128 */             return (o1.max() == o2.max()) ? 0 : ((o1.max() > o2.max()) ? -1 : 1);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 133 */     for (Booster b : bb) {
/*     */       
/* 135 */       GuiSection guiSection = new GuiSection();
/* 136 */       guiSection.addRightC(0, b.info.icon.resized(32));
/* 137 */       guiSection.addRightC(8, (SPRITE)(new GText((UI.FONT()).H2, b.info.name)).setMaxWidth(200));
/*     */ 
/*     */ 
/*     */       
/* 141 */       guiSection.addRightCAbs(200, (SPRITE)new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 145 */               b.format(text, b.get(HCLASS_RACE.clP()));
/*     */             }
/*     */           });
/* 148 */       arrayList.add(guiSection);
/*     */       
/* 150 */       guiSection.body().incrW(100.0D);
/* 151 */       guiSection.body().pad(2, 2);
/*     */     } 
/*     */     
/* 154 */     this.section.addRelBody(8, DIR.S, (RENDEROBJ)(new GScrollRows((Iterable)arrayList, ((RENDEROBJ)arrayList.get(0)).body().height() * 8)).view());
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 159 */     GuiSection s = new GuiSection();
/*     */     
/* 161 */     GStaples chart = new GStaples(32)
/*     */       {
/*     */         protected double getValue(int stapleI)
/*     */         {
/* 165 */           int i = 32 - stapleI - 1;
/* 166 */           return (STATS.DISEASE()).healthHistory.getD(i);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void hover(GBox box, int stapleI) {
/* 171 */           int i = 32 - stapleI - 1;
/* 172 */           box.title(bo.name);
/* 173 */           GText t = box.text();
/* 174 */           DicTime.setDaysAgo((Str)t, i);
/* 175 */           box.add((SPRITE)t);
/* 176 */           box.tab(6);
/* 177 */           box.add((SPRITE)GFORMAT.perc(box.text(), (STATS.DISEASE()).healthHistory.getD(i)));
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected void setColor(ColorImp c, int stapleI, double value) {
/* 184 */           if (value < 0.5D) {
/* 185 */             c.interpolate((GCOLOR.UI()).SOSO.normal, (GCOLOR.UI()).BAD.normal, 1.0D - value * 2.0D);
/*     */           } else {
/* 187 */             c.interpolate((GCOLOR.UI()).SOSO.normal, (GCOLOR.UI()).GOOD.normal, (value - 0.5D) * 2.0D);
/*     */           } 
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 193 */     chart.body().setDim(400.0D, 90.0D);
/*     */     
/* 195 */     s.addRelBody(4, DIR.S, (RENDEROBJ)chart);
/*     */     
/* 197 */     this.section.addDown(16, (RENDEROBJ)s);
/*     */ 
/*     */ 
/*     */     
/* 201 */     s = new GuiSection();
/* 202 */     s.add((RENDEROBJ)new GHeader(¤¤Diseases));
/*     */     
/* 204 */     LinkedList<RENDEROBJ> rows = new LinkedList();
/*     */     
/* 206 */     for (DISEASE d : DISEASES.all()) {
/* 207 */       GuiSection ss = new GuiSection();
/*     */       
/* 209 */       final GButt.ButtPanel b = new GButt.ButtPanel((UI.FONT()).M.getText(d.info.name))
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 213 */             if ((S.get()).developer) {
/* 214 */               STATS.DISEASE().outbreak(0.25D, d);
/*     */             }
/* 216 */             super.clickA();
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 221 */             d.hover(text);
/*     */           }
/*     */         };
/*     */       
/* 225 */       b.body.setWidth(280.0D);
/* 226 */       ss.add((RENDEROBJ)b);
/* 227 */       if ((S.get()).developer) {
/* 228 */         ss.addRightC(0, (RENDEROBJ)new GButt.ButtPanel((UI.icons()).s.death.resized(10))
/*     */             {
/*     */               protected void clickA() {
/* 231 */                 STATS.DISEASE().outbreak(d.infectRate, d);
/*     */               }
/*     */             });
/* 234 */         ss.addRightC(0, (RENDEROBJ)new GButt.ButtPanel((SPRITE)(UI.icons()).s.death)
/*     */             {
/*     */               protected void clickA() {
/* 237 */                 STATS.DISEASE().outbreak(1.0D, d);
/*     */               }
/*     */             });
/*     */       } 
/*     */ 
/*     */       
/* 243 */       rows.add(ss);
/*     */     } 
/*     */     
/* 246 */     s.addDown(2, (RENDEROBJ)(new GScrollRows((Iterable)rows, HEIGHT - this.section.body().height() - 80, this.section.body().width())).view());
/*     */     
/* 248 */     this.section.addDown(16, (RENDEROBJ)s);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static RENDEROBJ stat(final STAT st) {
/* 259 */     GuiSection s = new GuiSection();
/*     */     
/* 261 */     s.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 265 */             GFORMAT.i(text, st.data().get(null));
/*     */           }
/* 267 */         }).increase().hh((st.info()).name, (st.info()).desc, 250));
/*     */     
/* 269 */     s.addRightC(80, (RENDEROBJ)new GButt.ButtPanel((SPRITE)(UI.icons()).s.crossheir)
/*     */         {
/* 271 */           int ie = 0;
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 275 */             for (int i = 0; i < (SETT.ENTITIES().getAllEnts()).length; i++) {
/* 276 */               this.ie++;
/* 277 */               if (this.ie >= (SETT.ENTITIES().getAllEnts()).length)
/* 278 */                 this.ie = 0; 
/* 279 */               ENTITY e = SETT.ENTITIES().getAllEnts()[this.ie];
/* 280 */               if (e != null && e instanceof Humanoid) {
/* 281 */                 Humanoid a = (Humanoid)e;
/* 282 */                 if (st.indu().get(a.indu()) > 0) {
/* 283 */                   (VIEW.s().getWindow()).centererTile.set(a.tc());
/*     */                   break;
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 293 */             activeSet((st.data().get(null) > 0));
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 298 */     return (RENDEROBJ)s;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\health\UIHealth.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */