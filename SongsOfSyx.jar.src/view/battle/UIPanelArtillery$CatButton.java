/*     */ package view.battle;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.room.military.artillery.ArtilleryInstance;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GButt;
/*     */ import view.keyboard.KEYS;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CatButton
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   private final GETTER<Integer> ier;
/*     */   
/*     */   CatButton(GETTER<Integer> ier, CatSelection selection) {
/*  76 */     this.body.setDim(UIPanelArtillery.width, 28.0D);
/*  77 */     this.ier = ier;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  83 */     ArtilleryInstance ins = get();
/*  84 */     if (ins == null) {
/*     */       return;
/*     */     }
/*  87 */     isSelected = ins.selected;
/*  88 */     isHovered = ins.hovered;
/*  89 */     GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/*  90 */     GButt.ButtPanel.renderFrame(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/*  91 */     (ins.blueprintI().iconBig()).medium.render(r, body().x1() + 3, body().y1() + 3);
/*     */     
/*  93 */     if (ins.mustered()) {
/*  94 */       if (ins.targetDivGet() != null || ins.targetCooGet() != null) {
/*  95 */         (SPRITES.icons()).s.bow.render(r, body().x2() - 40, body().y1() + 6);
/*     */       }
/*  97 */       if (ins.menMustering() == 0.0D) {
/*  98 */         (GCOLOR.T()).IBAD.bind();
/*  99 */       } else if (ins.menMustering() == 1.0D) {
/* 100 */         (GCOLOR.T()).IGREAT.bind();
/*     */       } else {
/* 102 */         (GCOLOR.T()).IGOOD.bind();
/* 103 */       }  (SPRITES.icons()).s.human.render(r, body().x2() - 20, body().y1() + 6);
/* 104 */       COLOR.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 110 */     ArtilleryInstance ins = get();
/* 111 */     if (ins == null) {
/*     */       return;
/*     */     }
/* 114 */     if ((KEYS.MAIN()).MOD.isPressed()) {
/* 115 */       UIPanelArtillery.this.selection.toggle(ins);
/* 116 */       UIPanelArtillery.lastClicked = -1;
/* 117 */     } else if ((KEYS.MAIN()).UNDO.isPressed() && UIPanelArtillery.lastClicked != -1) {
/* 118 */       int s = UIPanelArtillery.lastClicked;
/* 119 */       int e = ((Integer)this.ier.get()).intValue();
/*     */       
/* 121 */       if (e < s) {
/* 122 */         int k = s;
/* 123 */         s = e;
/* 124 */         e = k;
/*     */       } 
/* 126 */       for (; s <= e; s++) {
/* 127 */         if (s >= 0 && s < UIPanelArtillery.this.selection.all().size())
/* 128 */           UIPanelArtillery.this.selection.select((ArtilleryInstance)UIPanelArtillery.this.selection.all().get(s)); 
/*     */       } 
/*     */     } else {
/* 131 */       UIPanelArtillery.this.selection.clear();
/* 132 */       UIPanelArtillery.this.selection.toggle(ins);
/* 133 */       UIPanelArtillery.lastClicked = ((Integer)this.ier.get()).intValue();
/*     */     } 
/*     */ 
/*     */     
/* 137 */     if (MButt.LEFT.isDouble()) {
/* 138 */       ((VIEW.s()).battle.getWindow()).centererTile.set(ins.body().cX(), ins.body().cY());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 144 */     ArtilleryInstance ins = get();
/* 145 */     if (ins == null)
/*     */       return; 
/* 147 */     ins.hover(text);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 152 */     if (super.hover(mCoo)) {
/* 153 */       ArtilleryInstance ins = get();
/* 154 */       if (ins != null)
/* 155 */         ins.hovered = true; 
/* 156 */       return true;
/*     */     } 
/* 158 */     return false;
/*     */   }
/*     */   
/*     */   private ArtilleryInstance get() {
/* 162 */     int i = ((Integer)this.ier.get()).intValue();
/* 163 */     if (i < 0 || i >= UIPanelArtillery.this.all.size())
/* 164 */       return null; 
/* 165 */     return (ArtilleryInstance)UIPanelArtillery.this.all.get(i);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\UIPanelArtillery$CatButton.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */