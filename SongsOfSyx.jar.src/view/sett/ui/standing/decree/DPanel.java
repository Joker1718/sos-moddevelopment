/*     */ package view.sett.ui.standing.decree;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.race.Race;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.stats.POP;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.muls.StatsMultipliers;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ final class DPanel extends ISidePanel {
/*  37 */   private static CharSequence ¤¤Cancel = "Click to cancel action for {0} subjects.";
/*  38 */   private static CharSequence ¤¤Set = "Set action for:";
/*  39 */   private static CharSequence ¤¤Projected = "Projected fulfillment increase";
/*  40 */   private static CharSequence ¤¤AutoPer = "Automatically execute this decree for {0} % of your population.";
/*  41 */   private static CharSequence ¤¤AutoAm = "Automatically execute this decree when population is above {0} people.";
/*     */   
/*     */   static {
/*  44 */     D.ts(DPanel.class);
/*     */   }
/*     */   
/*     */   DPanel(final HCLASS cl, final GETTER<Race> race) {
/*  48 */     titleSet(UIDecreeButt.¤¤title);
/*     */     
/*  50 */     this.section = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds) {
/*  53 */           if (cl == HCLASSES.CITIZEN() && race.get() == null) {
/*  54 */             (VIEW.s()).panels.remove(DPanel.this);
/*     */             return;
/*     */           } 
/*  57 */           super.render(r, ds);
/*     */         }
/*     */       };
/*     */     
/*  61 */     LinkedList<RENDEROBJ> rows = new LinkedList();
/*     */     
/*  63 */     for (StatsMultipliers.StatMultiplier m : STATS.MULTIPLIERS().get(cl)) {
/*  64 */       if (m.available(cl) && m instanceof StatsMultipliers.StatMultiplierAction) {
/*  65 */         StatsMultipliers.StatMultiplierAction dec = (StatsMultipliers.StatMultiplierAction)m;
/*  66 */         other(rows, dec, cl, race);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  73 */     this.section.add((RENDEROBJ)(new GScrollRows((Iterable)rows, HEIGHT - 16)).view());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void other(LinkedList<RENDEROBJ> rows, final StatsMultipliers.StatMultiplierAction dec, final HCLASS cl, final GETTER<Race> race) {
/*  79 */     GuiSection s = new GuiSection();
/*     */     
/*  81 */     s.add((RENDEROBJ)new Header(dec, cl, race));
/*  82 */     II ii = new II(cl, race, dec);
/*  83 */     GSliderInt sl = slider(dec, cl, race, ii);
/*  84 */     s.addDown(2, (RENDEROBJ)sl);
/*     */     
/*  86 */     s.addRelBody(16, DIR.E, (RENDEROBJ)marker(dec, cl, race, (INT)ii).pad(4, 4));
/*  87 */     if (dec.canUnmark()) {
/*  88 */       s.addRelBody(2, DIR.E, (RENDEROBJ)unmarker(dec, cl, race).pad(4, 4));
/*     */     }
/*     */     
/*  91 */     s.add((SPRITE)(UI.icons()).s.cog, 0, s.body().y2() + 2);
/*  92 */     final INT.INTE ee = new INT.INTE()
/*     */       {
/*     */         public int min()
/*     */         {
/*  96 */           return (dec.auto(cl, (Race)race.get())).min;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 101 */           return (dec.auto(cl, (Race)race.get())).max;
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 106 */           return dec.auto(cl, (Race)race.get()).get();
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 111 */           dec.auto(cl, (Race)race.get()).set(t);
/*     */         }
/*     */       };
/* 114 */     s.addRightC(8, (RENDEROBJ)new GSliderInt(ee, 100, true)
/*     */         {
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 117 */             GBox b = (GBox)text;
/* 118 */             GText t = b.text();
/* 119 */             if (dec == (STATS.MULTIPLIERS()).EMANCIPATE || dec == (STATS.MULTIPLIERS()).PROSECUTION) {
/* 120 */               t.add(DPanel.¤¤AutoAm).insert(0, ee.get());
/*     */             } else {
/* 122 */               t.add(DPanel.¤¤AutoPer).insert(0, ee.get());
/* 123 */             }  b.add((SPRITE)t);
/* 124 */             super.hoverInfoGet(text);
/*     */           }
/*     */         });
/*     */     
/* 128 */     s.pad(8, 10);
/*     */     
/* 130 */     rows.add(s);
/*     */   }
/*     */   
/*     */   private GButt.ButtPanel unmarker(final StatsMultipliers.StatMultiplierAction dec, final HCLASS cl, final GETTER<Race> rr) {
/* 134 */     return new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.cancel)
/*     */       {
/*     */         protected void clickA() {
/* 137 */           dec.unmark(cl, (Race)rr.get());
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 142 */           activeSet((dec.unmarkable(cl, (Race)rr.get()) > 0));
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 147 */           GBox b = (GBox)text;
/* 148 */           GText t = b.text();
/* 149 */           t.add(DPanel.¤¤Cancel);
/* 150 */           t.insert(0, dec.unmarkable(cl, (Race)rr.get()));
/* 151 */           b.add((SPRITE)t);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   private GSliderInt slider(final StatsMultipliers.StatMultiplierAction dec, final HCLASS cl, final GETTER<Race> rr, final INT.INTE ii) {
/* 158 */     return new GSliderInt(ii, 280, true)
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 161 */           DPanel.hov(text, cl, (Race)rr.get(), dec, ii.get());
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private GButt.ButtPanel marker(final StatsMultipliers.StatMultiplierAction dec, final HCLASS cl, final GETTER<Race> rr, final INT ii) {
/* 167 */     return new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.ok)
/*     */       {
/*     */         protected void clickA() {
/* 170 */           dec.mark(cl, (Race)rr.get(), ii.get());
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 175 */           activeSet((ii.get() != 0));
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 180 */           DPanel.hov(text, cl, (Race)rr.get(), dec, ii.get());
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void hov(GUI_BOX text, HCLASS cl, Race race, StatsMultipliers.StatMultiplierAction dec, int am) {
/* 189 */     GBox b = (GBox)text;
/* 190 */     b.title(dec.name);
/*     */     
/* 192 */     b.textLL(¤¤Set);
/* 193 */     b.NL();
/* 194 */     b.add((SPRITE)GFORMAT.i(b.text(), am));
/* 195 */     b.text(race.info.names);
/*     */     
/* 197 */     b.NL(8);
/*     */     
/* 199 */     GText t = b.text();
/* 200 */     t.add(¤¤Projected);
/* 201 */     t.lablify();
/* 202 */     b.add((SPRITE)t);
/* 203 */     b.NL(2);
/*     */ 
/*     */ 
/*     */     
/* 207 */     double d = am / POP.pop(cl, race);
/* 208 */     dec.boosters.hover(text, d, null, -1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 223 */     b.NL(8);
/*     */     
/* 225 */     dec.info(b, am);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Header
/*     */     extends GuiSection
/*     */   {
/*     */     private final HCLASS cl;
/*     */     private final GETTER<Race> race;
/*     */     private final StatsMultipliers.StatMultiplierAction dec;
/*     */     
/*     */     Header(final StatsMultipliers.StatMultiplierAction dec, final HCLASS cl, final GETTER<Race> race) {
/* 237 */       this.cl = cl;
/* 238 */       this.race = race;
/* 239 */       this.dec = dec;
/* 240 */       add(dec.icon, 0, 0);
/*     */ 
/*     */       
/* 243 */       addCentredY((RENDEROBJ)new GHeader(dec.verb), 48);
/*     */       
/* 245 */       addCentredY((SPRITE)new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 249 */               GFORMAT.f0(text, dec.value(cl, (Race)race.get(), 0));
/*     */             }
/* 252 */           }260);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 260 */       GBox b = (GBox)text;
/* 261 */       b.title(this.dec.name);
/* 262 */       b.text(this.dec.desc);
/* 263 */       b.NL(8);
/*     */       
/* 265 */       this.dec.boosters.hover(text, (BOOSTABLE_O)HCLASS_RACE.clP((Race)this.race.get(), this.cl));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class II
/*     */     implements INT.INTE
/*     */   {
/* 273 */     int i = 0;
/*     */     private final HCLASS cl;
/*     */     private final GETTER<Race> race;
/*     */     private final StatsMultipliers.StatMultiplierAction dec;
/*     */     
/*     */     II(HCLASS cl, GETTER<Race> race, StatsMultipliers.StatMultiplierAction dec) {
/* 279 */       this.cl = cl;
/* 280 */       this.race = race;
/* 281 */       this.dec = dec;
/*     */     }
/*     */ 
/*     */     
/*     */     public int min() {
/* 286 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public int max() {
/* 291 */       return this.dec.maxAmount(this.cl, (Race)this.race.get());
/*     */     }
/*     */ 
/*     */     
/*     */     public int get() {
/* 296 */       return CLAMP.i(this.i, 0, max());
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(int t) {
/* 301 */       this.i = t;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\decree\DPanel.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */