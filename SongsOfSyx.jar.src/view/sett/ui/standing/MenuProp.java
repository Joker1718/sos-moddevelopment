/*     */ package view.sett.ui.standing;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoostableCat;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsTraits;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.ISidePanel;
/*     */ 
/*     */ class MenuProp extends ISidePanel {
/*     */   private final HCLASS c;
/*     */   
/*     */   MenuProp(final HCLASS c, final GETTER<Race> race) {
/*  35 */     titleSet(Dic.¤¤Properites);
/*  36 */     this.race = race;
/*  37 */     this.c = c;
/*  38 */     LinkedList<RENDEROBJ> rows = new LinkedList();
/*     */     
/*  40 */     for (BoostableCat col : BOOSTABLES.colls()) {
/*     */       
/*  42 */       rows.add(new GHeader(col.name));
/*     */       
/*  44 */       for (Boostable bo : col.all()) {
/*  45 */         rows.add(new Row(bo));
/*     */       }
/*     */       
/*  48 */       rows.add(new RENDEROBJ.RenderDummy(10, 16));
/*     */     } 
/*     */ 
/*     */     
/*  52 */     rows.add(new GHeader((STATS.TRAITS()).info.names));
/*     */ 
/*     */     
/*  55 */     StatsTraits pp = STATS.TRAITS();
/*     */     
/*  57 */     for (StatsTraits.StatTrait p : pp.all()) {
/*     */       
/*  59 */       rows.add((new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/*  63 */               GFORMAT.perc(text, p.getD(c, (Race)race.get()));
/*     */             }
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GBox b) {
/*  68 */               b.title(p.trait.info.name);
/*  69 */               b.text(p.trait.info.desc);
/*  70 */               b.NL();
/*  71 */               b.add((SPRITE)GFORMAT.i(b.text(), p.get(c, (Race)race.get())));
/*     */             }
/*  74 */           }).hh(p.trait.info.name, 150));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  80 */     this.section.add((RENDEROBJ)(new GScrollRows((Iterable)rows, HEIGHT)).view());
/*     */   }
/*     */   
/*     */   private final GETTER<Race> race;
/*     */   
/*     */   private class Row extends GuiSection {
/*     */     private final Boostable bo;
/*     */     
/*     */     Row(final Boostable bo) {
/*  89 */       this.bo = bo;
/*     */       
/*  91 */       add((SPRITE)bo.icon, 0, 0);
/*  92 */       addRightC(2, (SPRITE)new GText((UI.FONT()).M, bo.name));
/*  93 */       addRightCAbs(250, (SPRITE)new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/*  97 */               GFORMAT.f(text, bo.get((BOOSTABLE_O)HCLASS_RACE.clP((Race)(MenuProp.Row.access$0(MenuProp.Row.this)).race.get(), (MenuProp.Row.access$0(MenuProp.Row.this)).c)));
/*     */             }
/*     */           });
/* 100 */       body().incrW(64.0D);
/* 101 */       pad(2, 2);
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 106 */       if (hoveredIs())
/* 107 */         COLOR.WHITE15.render(r, (RECTANGLE)body()); 
/* 108 */       super.render(r, ds);
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 113 */       GBox b = (GBox)text;
/* 114 */       b.title(this.bo.name);
/* 115 */       b.text(this.bo.desc);
/* 116 */       b.NL(8);
/*     */       
/* 118 */       this.bo.hover((GUI_BOX)b, (BOOSTABLE_O)HCLASS_RACE.clP((Race)MenuProp.this.race.get(), MenuProp.this.c), true);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void update(float ds) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\MenuProp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */