/*     */ package world.region;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.STRING_RECIEVER;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.common.BitmapSpriteEditor;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GColorPicker;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import view.main.VIEW;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
/*     */ import view.tool.PlacableSimpleTile;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ 
/*     */ 
/*     */ class Placers
/*     */   extends ArrayListGrower<PLACABLE>
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public Placers() {
/*  40 */     final INT.IntImp ii = new INT.IntImp(1, FACTIONS.MAX());
/*  41 */     GSliderInt sl = new GSliderInt((INT.INTE)ii, 100, true);
/*  42 */     final LinkedList<CLICKABLE> butts = new LinkedList();
/*  43 */     butts.add(sl);
/*     */     
/*  45 */     final PlacableMulti undo = new PlacableMulti("remove faction")
/*     */       {
/*     */         public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */         {
/*  49 */           Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/*  50 */           if (reg != null && reg.faction() != null) {
/*  51 */             RD.setFaction(reg, null, false);
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/*  57 */           Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/*  58 */           if (reg != null && reg.faction() != null) {
/*  59 */             return null;
/*     */           }
/*  61 */           return E;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean expandsTo(int fromX, int fromY, int toX, int toY) {
/*  66 */           Region reg = (Region)(WORLD.REGIONS()).map.get(fromX, fromY);
/*  67 */           return (reg != null && reg.is(toX, toY));
/*     */         }
/*     */       };
/*     */     
/*  71 */     PlacableMulti placableMulti2 = new PlacableMulti("set faction", "", (SPRITE)(UI.icons()).m.flag)
/*     */       {
/*     */         public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */         {
/*  75 */           Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/*  76 */           if (reg != null) {
/*  77 */             RD.setFaction(reg, FACTIONS.getByIndex(ii.get()), false);
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/*  83 */           Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/*  84 */           if (reg != null) {
/*  85 */             return null;
/*     */           }
/*  87 */           return E;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean expandsTo(int fromX, int fromY, int toX, int toY) {
/*  92 */           Region reg = (Region)(WORLD.REGIONS()).map.get(fromX, fromY);
/*  93 */           return (reg != null && reg.is(toX, toY));
/*     */         }
/*     */ 
/*     */         
/*     */         public PLACABLE getUndo() {
/*  98 */           return undo;
/*     */         }
/*     */         
/*     */         public LIST<CLICKABLE> getAdditionalButt() {
/* 102 */           return (LIST<CLICKABLE>)butts;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 107 */     PlacableSimpleTile placableSimpleTile1 = new PlacableSimpleTile("generate stats race")
/*     */       {
/* 109 */         private RDRace race = (RDRace)(RD.RACES()).all.get(0);
/* 110 */         LinkedList<CLICKABLE> butts = new LinkedList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void place(int tx, int ty) {
/* 132 */           Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/* 133 */           if (reg != null && reg.faction() instanceof FactionNPC) {
/* 134 */             ((FactionNPC)reg.faction()).generate(this.race, false);
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty) {
/* 140 */           Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/* 141 */           if (reg != null && reg.faction() instanceof FactionNPC) {
/* 142 */             return null;
/*     */           }
/* 144 */           return E;
/*     */         }
/*     */ 
/*     */         
/*     */         public SPRITE getIcon() {
/* 149 */           return (SPRITE)(UI.icons()).m.citizen;
/*     */         }
/*     */ 
/*     */         
/*     */         public LIST<CLICKABLE> getAdditionalButt() {
/* 154 */           return (LIST<CLICKABLE>)this.butts;
/*     */         }
/*     */       };
/*     */     
/* 158 */     PlacableSimpleTile placableSimpleTile2 = new PlacableSimpleTile("set faction name")
/*     */       {
/*     */         public void place(int tx, int ty)
/*     */         {
/* 162 */           final Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/* 163 */           if (reg != null && reg.faction() instanceof FactionNPC) {
/* 164 */             STRING_RECIEVER str = new STRING_RECIEVER()
/*     */               {
/*     */                 public void acceptString(CharSequence string)
/*     */                 {
/* 168 */                   if (string != null)
/* 169 */                     (reg.faction()).name.clear().add(string); 
/* 170 */                   (reg.faction().capitolRegion()).info.name().clear().add((CharSequence)(reg.faction()).name);
/*     */                 }
/*     */               };
/*     */             
/* 174 */             (VIEW.inters()).input.requestInput(str, "set faction name");
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty) {
/* 180 */           Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/* 181 */           if (reg != null && reg.faction() instanceof FactionNPC) {
/* 182 */             return null;
/*     */           }
/* 184 */           return E;
/*     */         }
/*     */ 
/*     */         
/*     */         public SPRITE getIcon() {
/* 189 */           return (SPRITE)(UI.icons()).m.menu;
/*     */         }
/*     */       };
/*     */     
/* 193 */     PlacableSimpleTile placableSimpleTile3 = new PlacableSimpleTile("set faction visuals")
/*     */       {
/*     */         GETTER.GETTER_IMP<FactionNPC> g;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         GuiSection s;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         BitmapSpriteEditor ee;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void place(int tx, int ty) {
/* 219 */           Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/* 220 */           if (reg != null && reg.faction() instanceof FactionNPC) {
/* 221 */             this.g.set(reg.faction());
/* 222 */             this.ee.spriteSet((reg.faction().banner()).sprite);
/* 223 */             (VIEW.inters()).popup.show((RENDEROBJ)this.s, null);
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty) {
/* 229 */           Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/* 230 */           if (reg != null && reg.faction() instanceof FactionNPC) {
/* 231 */             return null;
/*     */           }
/* 233 */           return E;
/*     */         }
/*     */ 
/*     */         
/*     */         public SPRITE getIcon() {
/* 238 */           return (SPRITE)(UI.icons()).m.flag;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 244 */     add(placableMulti2);
/* 245 */     add(placableMulti1);
/* 246 */     add(placableSimpleTile1);
/* 247 */     add(placableSimpleTile2);
/* 248 */     add(placableSimpleTile3);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\Placers.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */