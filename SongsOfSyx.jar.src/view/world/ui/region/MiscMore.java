/*     */ package view.world.ui.region;
/*     */ 
/*     */ import init.constant.Config;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import world.army.WDIV;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.building.RDBuilding;
/*     */ import world.region.building.RDBuildingLevel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class MiscMore
/*     */   extends GuiSection
/*     */ {
/*     */   public static RENDEROBJ garrison(GETTER.GETTER_IMP<Region> g, int width) {
/*  39 */     GuiSection ss = new GuiSection();
/*     */     
/*  41 */     LinkedList<RENDEROBJ> rows = new LinkedList();
/*     */     
/*  43 */     int row = width / 24;
/*     */     
/*  45 */     if ((Config.battle()).REGION_MAX_DIVS / row >= 3) {
/*  46 */       row = (width - 24) / 24;
/*     */     }
/*     */     
/*  49 */     for (int i = 0; i < (Config.battle()).REGION_MAX_DIVS; i++) {
/*     */       
/*  51 */       GuiSection s = new GuiSection();
/*  52 */       rows.add(s);
/*  53 */       for (int k = 0; k < row && i < (Config.battle()).REGION_MAX_DIVS; k++) {
/*  54 */         s.addRightC(0, (RENDEROBJ)new DivCard(i, g));
/*  55 */         i++;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  60 */     if (rows.size() < 3) {
/*  61 */       GuiSection s = new GuiSection();
/*  62 */       for (RENDEROBJ o : rows)
/*  63 */         s.addDown(0, o); 
/*  64 */       ss.addRightCAbs(48, (RENDEROBJ)s);
/*     */     } else {
/*  66 */       ss.addRightCAbs(48, (RENDEROBJ)(new GScrollRows((Iterable)rows, ((RENDEROBJ)rows.get(0)).body().height() * 3)).view());
/*     */     } 
/*  68 */     return (RENDEROBJ)ss;
/*     */   }
/*     */ 
/*     */   
/*     */   public static RENDEROBJ buildings(final GETTER.GETTER_IMP<Region> g) {
/*  73 */     final int cols = 11;
/*  74 */     final ArrayList<RDBuilding> buildings = new ArrayList((RD.BUILDINGS()).all.size());
/*     */     
/*  76 */     GuiSection ss = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/*  80 */           buildings.clear();
/*  81 */           for (RDBuilding bu : (RD.BUILDINGS()).all) {
/*  82 */             if (bu.level.get(g.get()) > 0)
/*  83 */               buildings.add(bu); 
/*     */           } 
/*  85 */           super.render(r, ds);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  90 */     GTableBuilder bu = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/*  94 */           return (int)Math.ceil(buildings.size() / cols);
/*     */         }
/*     */       };
/*     */     
/*  98 */     bu.column(null, cols * 32, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 102 */             GuiSection s = new GuiSection();
/* 103 */             for (int i = 0; i < cols; i++) {
/* 104 */               final int k = i;
/* 105 */               s.addRightC(0, (RENDEROBJ)new HOVERABLE.HoverableAbs(32, 32)
/*     */                   {
/*     */                     
/*     */                     protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */                     {
/* 110 */                       RDBuilding bu = (RDBuilding)buildings.get(k + ((Integer)ier.get()).intValue() * cols);
/* 111 */                       if (bu != null) {
/* 112 */                         ((RDBuildingLevel)bu.levels.get(bu.level.get(g.get()))).icon.render(r, (RECTANGLE)this.body);
/*     */                       }
/*     */                     }
/*     */ 
/*     */                     
/*     */                     public void hoverInfoGet(GUI_BOX text) {
/* 118 */                       RDBuilding bu = (RDBuilding)buildings.get(k + ((Integer)ier.get()).intValue() * cols);
/* 119 */                       if (bu != null) {
/* 120 */                         RDBuildingLevel l = (RDBuildingLevel)bu.levels.get(bu.level.get(g.get()));
/* 121 */                         text.title(l.name);
/* 122 */                         text.text(bu.info.desc);
/*     */                       } 
/*     */                     }
/*     */                   });
/*     */             } 
/*     */             
/* 128 */             return (RENDEROBJ)s;
/*     */           }
/*     */         });
/*     */     
/* 132 */     ss.add((RENDEROBJ)bu.create(3, false));
/*     */     
/* 134 */     ss.addRelBody(2, DIR.N, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 138 */             GFORMAT.i(text, RD.DEVASTATION().raidCredits((Region)g.get()));
/*     */           }
/* 141 */         }).hh((SPRITE)(UI.icons()).s.money).hoverTitleSet(Dic.¤¤Spoils));
/*     */     
/* 143 */     return (RENDEROBJ)ss;
/*     */   }
/*     */   
/*     */   public static class DivCard
/*     */     extends HOVERABLE.HoverableAbs {
/*     */     private final int di;
/*     */     private final GETTER.GETTER_IMP<Region> g;
/*     */     
/*     */     DivCard(int di, GETTER.GETTER_IMP<Region> g) {
/* 152 */       super(24, 24);
/* 153 */       this.g = g;
/* 154 */       this.di = di;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 159 */       LIST<WDIV> divs = RD.MILITARY().divisions((Region)this.g.get());
/*     */       
/* 161 */       if (this.di < divs.size()) {
/* 162 */         WDIV d = (WDIV)divs.get(this.di);
/* 163 */         (d.race().appearance()).icon.render(r, (RECTANGLE)this.body);
/* 164 */         int width = (int)((body().width() * d.menTarget()) / (Config.battle()).MEN_PER_DIVISION);
/* 165 */         double dd = d.men() / d.menTarget();
/* 166 */         GMeter.render(r, GMeter.C_REDGREEN, dd, this.body.x1(), this.body.x1() + width, this.body.y2() - 8, this.body.y2());
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 173 */       GBox b = (GBox)text;
/* 174 */       LIST<WDIV> divs = RD.MILITARY().divisions((Region)this.g.get());
/*     */       
/* 176 */       if (this.di < divs.size()) {
/* 177 */         WDIV d = (WDIV)divs.get(this.di);
/* 178 */         (VIEW.UI()).div.world.hover(d, (GUI_BOX)b);
/*     */       } 
/*     */ 
/*     */       
/* 182 */       super.hoverInfoGet(text);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\MiscMore.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */