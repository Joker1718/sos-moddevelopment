/*     */ package util.gui.common;
/*     */ 
/*     */ import game.faction.FBanner;
/*     */ import game.faction.Faction;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import view.main.VIEW;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ public abstract class UIPickerRegion extends GuiSection {
/*     */   protected boolean active(Region reg) {
/*  27 */     return true;
/*     */   } private GETTER<? extends Faction> g;
/*     */   protected boolean selected(Region reg) {
/*  30 */     return false;
/*     */   }
/*     */   protected abstract void toggle(Region paramRegion);
/*     */   
/*     */   protected void hoverInfo(GBox b, Region reg) {
/*  35 */     (VIEW.world()).UI.regions.hover(reg, (GUI_BOX)b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UIPickerRegion(final GETTER<? extends Faction> g, int height) {
/*  42 */     this.g = g;
/*     */     
/*  44 */     GTableBuilder builder = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/*  48 */           if (g.get() == null) {
/*  49 */             return 0;
/*     */           }
/*  51 */           return ((Faction)g.get()).realm().regions();
/*     */         }
/*     */       };
/*     */     
/*  55 */     builder.column("", 264, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(GETTER<Integer> ier)
/*     */           {
/*  59 */             return (RENDEROBJ)new UIPickerRegion.Button(ier);
/*     */           }
/*     */         });
/*     */     
/*  63 */     add((RENDEROBJ)builder.createHeight(height, false));
/*     */   }
/*     */ 
/*     */   
/*     */   private class Button
/*     */     extends CLICKABLE.ClickableAbs
/*     */   {
/*     */     private final GETTER<Integer> ier;
/*     */     
/*     */     public Button(GETTER<Integer> ier) {
/*  73 */       this.ier = ier;
/*  74 */       this.body.setWidth(264.0D);
/*  75 */       this.body.setHeight(40.0D);
/*     */     }
/*     */     
/*     */     private Region r() {
/*  79 */       return ((Faction)UIPickerRegion.this.g.get()).realm().region(((Integer)this.ier.get()).intValue());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  85 */       Region reg = r();
/*  86 */       if (reg == null) {
/*     */         return;
/*     */       }
/*  89 */       isSelected = UIPickerRegion.this.selected(reg);
/*  90 */       GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/*     */       
/*  92 */       SPRITE b = FBanner.rebel.MEDIUM;
/*  93 */       if (reg.faction() != null) {
/*  94 */         b = (reg.faction().banner()).MEDIUM;
/*     */       }
/*  96 */       b.renderCY(r, body().x1() + 8, body().cY());
/*     */       
/*  98 */       (GCOLOR.T()).H1.bind();
/*  99 */       (UI.FONT()).H2.render(r, (CharSequence)reg.info.name(), body().x1() + 40, body().cY() - (UI.FONT()).H2.height() / 2);
/*     */       
/* 101 */       if (!UIPickerRegion.this.active(reg)) {
/* 102 */         OPACITY.O35.bind();
/* 103 */         COLOR.BLACK.render(r, (RECTANGLE)this.body, -4);
/* 104 */         OPACITY.unbind();
/*     */       } 
/*     */       
/* 107 */       GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 114 */       Region reg = r();
/* 115 */       if (reg == null) {
/*     */         return;
/*     */       }
/* 118 */       if (UIPickerRegion.this.active(reg)) {
/* 119 */         UIPickerRegion.this.toggle(reg);
/*     */       }
/*     */     }
/*     */     
/*     */     public boolean hover(COORDINATE mCoo) {
/* 124 */       if (super.hover(mCoo)) {
/* 125 */         Region reg = r();
/* 126 */         if (reg != null)
/* 127 */           WORLD.MINIMAP().hilight(reg); 
/* 128 */         return true;
/*     */       } 
/* 130 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 135 */       Region reg = r();
/* 136 */       if (reg == null)
/*     */         return; 
/* 138 */       UIPickerRegion.this.hoverInfo((GBox)text, reg);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\common\UIPickerRegion.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */