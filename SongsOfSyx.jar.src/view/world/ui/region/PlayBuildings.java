/*     */ package view.world.ui.region;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.building.RDBuilding;
/*     */ 
/*     */ 
/*     */ class PlayBuildings
/*     */   extends GuiSection
/*     */ {
/*  25 */   private final ArrayList<RENDEROBJ> activeButts = new ArrayList((RD.BUILDINGS()).all.size());
/*  26 */   private final RENDEROBJ[] butts = new RENDEROBJ[(RD.BUILDINGS()).all.size() + 1];
/*     */   
/*  28 */   private static CharSequence ¤¤Click = "Click to construct buildings.";
/*     */   
/*     */   static {
/*  31 */     D.ts(PlayBuildings.class);
/*     */   }
/*     */   
/*  34 */   public int width = 72;
/*     */   
/*     */   public static final int height = 88;
/*     */   
/*     */   private final int amX;
/*     */   private final PlayBuildingsPop build;
/*     */   
/*     */   PlayBuildings(final GETTER.GETTER_IMP<Region> g, int width, int height) {
/*  42 */     this.build = new PlayBuildingsPop(null, g);
/*  43 */     this.width = (width - 28) / 7 & 0xFFFFFFFE;
/*  44 */     for (int i = 0; i < (RD.BUILDINGS()).sorted.size(); i++) {
/*  45 */       final RDBuilding bu = (RDBuilding)(RD.BUILDINGS()).sorted.get(i);
/*     */       
/*  47 */       this.butts[i] = (RENDEROBJ)new HOVERABLE.HoverableAbs(PlayBuildingsPop.width, 88)
/*     */         {
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */           {
/*  51 */             PlayBuildings.this.build.render(bu, (Region)g.get(), (RECTANGLE)this.body, r, true, false, isHovered);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/*  57 */             PlayBuildings.this.build.hover(bu, (Region)g.get(), text);
/*     */           }
/*     */         };
/*     */     } 
/*     */ 
/*     */     
/*  63 */     this.amX = (width - 24) / this.width;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  68 */     GTableBuilder builder = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/*  72 */           return (int)Math.ceil(PlayBuildings.this.activeButts.size() / PlayBuildings.this.amX);
/*     */         }
/*     */       };
/*     */     
/*  76 */     builder.column(null, this.amX * this.width, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(GETTER<Integer> ier)
/*     */           {
/*  80 */             return (RENDEROBJ)new PlayBuildings.Row(ier);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  85 */     int hi = height - body().height() - 16;
/*  86 */     int h = hi / 104;
/*  87 */     GuiSection guiSection1 = (h < 1) ? builder.createHeight(88, false) : builder.createHeight(104 * h, false);
/*     */     
/*  89 */     GuiSection sec = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/*  93 */           boolean hov = hoveredIs();
/*  94 */           GButt.ButtPanel.renderBG(r, true, false, hov, (RECTANGLE)body());
/*  95 */           GButt.ButtPanel.renderFrame(r, (RECTANGLE)body());
/*     */           
/*  97 */           PlayBuildings.this.activeButts.clearSloppy();
/*  98 */           for (int i = 0; i < (RD.BUILDINGS()).sorted.size(); i++) {
/*  99 */             RDBuilding b = (RDBuilding)(RD.BUILDINGS()).sorted.get(i);
/* 100 */             if (RD.BUILDINGS().tmp().level(b, (Region)g.get()) != 0) {
/* 101 */               PlayBuildings.this.activeButts.add(PlayBuildings.this.butts[i]);
/*     */             }
/*     */           } 
/* 104 */           if (PlayBuildings.this.activeButts.size() == 0) {
/* 105 */             (UI.icons()).m.building.renderC(r, (RECTANGLE)body());
/*     */           }
/*     */           
/* 108 */           super.render(r, ds);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean click() {
/* 113 */           PlayBuildings.this.build.pop((RECTANGLE)PlayBuildings.this.body());
/* 114 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 119 */           super.hoverInfoGet(text);
/* 120 */           if (text.emptyIs()) {
/* 121 */             text.title(Dic.¤¤Buildings);
/* 122 */             text.text(PlayBuildings.¤¤Click);
/*     */           } 
/*     */         }
/*     */       };
/*     */     
/* 127 */     sec.add((RENDEROBJ)guiSection1);
/* 128 */     sec.pad(6);
/* 129 */     addRelBody(12, DIR.S, (RENDEROBJ)sec);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class Row
/*     */     extends GuiSection
/*     */   {
/*     */     private final GETTER<Integer> ier;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Row(GETTER<Integer> ier) {
/* 147 */       this.ier = ier;
/* 148 */       body().setHeight(104.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 153 */       int x1 = body().x1();
/* 154 */       int y1 = body().y1();
/* 155 */       clear();
/* 156 */       int s = ((Integer)this.ier.get()).intValue() * PlayBuildings.this.amX;
/* 157 */       for (int i = 0; i < PlayBuildings.this.amX && i + s < PlayBuildings.this.activeButts.size(); i++) {
/* 158 */         addRightC(0, (RENDEROBJ)PlayBuildings.this.activeButts.get(i + s));
/*     */       }
/* 160 */       body().setHeight(104.0D);
/* 161 */       body().moveX1(x1);
/* 162 */       body().moveY1(y1);
/* 163 */       super.render(r, ds);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\PlayBuildings.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */