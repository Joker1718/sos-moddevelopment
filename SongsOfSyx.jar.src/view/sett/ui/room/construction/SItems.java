/*     */ package view.sett.ui.room.construction;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.room.main.furnisher.FurnisherItemGroup;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.text.D;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ final class SItems {
/*  24 */   private static CharSequence ¤¤Items = "¤items";
/*     */   
/*  26 */   private final RENDEROBJ title = (RENDEROBJ)(new GHeader(¤¤Items)).subify();
/*  27 */   private final GuiSection section = new GuiSection();
/*     */   private final RENDEROBJ table;
/*  29 */   private final GuiSection stolen = new GuiSection();
/*     */   private final State state;
/*  31 */   private final IButt[] butts = new IButt[8];
/*     */ 
/*     */   
/*     */   static {
/*  35 */     D.ts(SItems.class);
/*     */   }
/*     */   
/*     */   SItems(final State state) {
/*  39 */     this.state = state;
/*     */     
/*  41 */     GTableBuilder b = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/*  45 */           return (state.b == null) ? 0 : state.b.constructor().groups().size();
/*     */         }
/*     */       };
/*     */     
/*  49 */     b.column(null, 190, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(GETTER<Integer> ier)
/*     */           {
/*  53 */             return (RENDEROBJ)new SItems.IButt(state, ier);
/*     */           }
/*     */         });
/*     */     
/*  57 */     this.table = (RENDEROBJ)b.create(4, false);
/*     */     
/*  59 */     for (int i = 0; i < this.butts.length; i++) {
/*  60 */       final int k = i;
/*  61 */       GETTER<Integer> g = new GETTER<Integer>()
/*     */         {
/*     */           public Integer get()
/*     */           {
/*  65 */             return Integer.valueOf(k);
/*     */           }
/*     */         };
/*     */       
/*  69 */       this.butts[i] = new IButt(state, g);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   GuiSection get() {
/* 103 */     this.section.clear();
/*     */     
/* 105 */     this.section.addRightC(0, this.title);
/* 106 */     this.stolen.clear();
/* 107 */     this.stolen.body().setDim(1.0D, 32.0D);
/* 108 */     if ((VIEW.s()).tools.is(this.state.placement.placer.itemPlacerCurrent()))
/* 109 */       (VIEW.s()).tools.placer.stealButtons(this.stolen, true); 
/* 110 */     this.section.addRightC(8, (RENDEROBJ)this.stolen);
/* 111 */     this.section.add(this.table, 0, this.section.getLastY2() + 4);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 117 */     return this.section;
/*     */   }
/*     */   
/*     */   GuiSection getFlat() {
/* 121 */     this.section.clear();
/* 122 */     this.section.addRightC(0, this.title);
/* 123 */     this.stolen.clear();
/* 124 */     this.stolen.body().setDim(1.0D, 32.0D);
/* 125 */     if ((VIEW.s()).tools.is(this.state.placement.placer.itemPlacerCurrent()))
/* 126 */       (VIEW.s()).tools.placer.stealButtons(this.stolen, true); 
/* 127 */     this.section.addRightC(8, (RENDEROBJ)this.stolen);
/* 128 */     int y1 = this.section.getLastY2() + 4;
/* 129 */     for (int i = 0; i < this.state.b.constructor().groups().size(); i++) {
/* 130 */       this.section.add((RENDEROBJ)this.butts[i], i % 2 * (this.butts[0]).body.width(), y1 + i / 2 * (this.butts[0]).body.height());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 135 */     return this.section;
/*     */   }
/*     */   
/*     */   GuiSection getSingle() {
/* 139 */     this.section.clear();
/* 140 */     this.section.addRightC(0, this.title);
/* 141 */     this.stolen.clear();
/* 142 */     this.stolen.body().setDim(1.0D, 32.0D);
/* 143 */     if ((VIEW.s()).tools.is(this.state.placement.placer.itemPlacerCurrent()))
/* 144 */       (VIEW.s()).tools.placer.stealButtons(this.stolen, true); 
/* 145 */     this.section.addRightC(8, (RENDEROBJ)this.stolen);
/*     */ 
/*     */ 
/*     */     
/* 149 */     return this.section;
/*     */   }
/*     */   
/*     */   static class IButt
/*     */     extends GButt.ButtPanel
/*     */   {
/*     */     private final GETTER<Integer> ier;
/*     */     private final State state;
/*     */     
/*     */     IButt(State state, GETTER<Integer> ier) {
/* 159 */       super((SPRITE)new GStat(state, ier)
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 163 */               text.lablify().add(((FurnisherItemGroup)state.b.constructor().groups().get(((Integer)ier.get()).intValue())).name());
/*     */             }
/*     */           });
/* 166 */       this.state = state;
/* 167 */       this.ier = ier;
/* 168 */       setDim(190, 24);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void renAction() {
/* 173 */       selectedSet(((VIEW.s()).tools.placer.getCurrent() == this.state.placement.placer.itemPlacerCurrent() && this.state.item() == ((Integer)this.ier.get()).intValue()));
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 178 */       super.render(r, ds, isActive, isSelected, isHovered);
/* 179 */       if (this.state.problemGroup == this.state.b.constructor().groups().get(((Integer)this.ier.get()).intValue()) && this.state.problemTimer > VIEW.renderSecond()) {
/* 180 */         COLOR.RED100.renderFrame(r, (RECTANGLE)this.body, 2, 3);
/* 181 */         OPACITY.O25To50.bind();
/* 182 */         COLOR.RED100.render(r, (RECTANGLE)this.body);
/* 183 */         OPACITY.unbind();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 189 */       if (this.state.placement.placer.item(((Integer)this.ier.get()).intValue()) == null) {
/*     */         return;
/*     */       }
/* 192 */       this.state.setItem(((Integer)this.ier.get()).intValue());
/* 193 */       (VIEW.s()).tools.place((PLACABLE)this.state.placement.placer.item(((Integer)this.ier.get()).intValue()), this.state.config);
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 198 */       text.title(((FurnisherItemGroup)this.state.b.constructor().groups().get(((Integer)this.ier.get()).intValue())).name());
/* 199 */       text.text(((FurnisherItemGroup)this.state.b.constructor().groups().get(((Integer)this.ier.get()).intValue())).desc());
/*     */       
/* 201 */       GBox b = (GBox)text;
/* 202 */       b.NL(8);
/* 203 */       for (FurnisherStat s : this.state.b.constructor().stats()) {
/* 204 */         double d = ((FurnisherItemGroup)this.state.b.constructor().groups().get(((Integer)this.ier.get()).intValue())).stat(s.index());
/* 205 */         if (d < 0.0D) {
/* 206 */           b.error(s.name());
/* 207 */           b.tab(6);
/* 208 */           b.add((SPRITE)(SPRITES.icons()).m.minus);
/* 209 */         } else if (d > 0.0D) {
/* 210 */           b.text(s.name());
/* 211 */           b.tab(6);
/* 212 */           b.add((SPRITE)(SPRITES.icons()).m.plus);
/*     */         } 
/* 214 */         b.NL();
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\construction\SItems.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */