/*     */ package view.sett.ui.subject;
/*     */ 
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModule;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GText;
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
/*     */ class null
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   null(int $anonymous0, int $anonymous1) {
/* 111 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 116 */     isSelected = m.is(UISubjectProperties.this.a.a, (AIManager)UISubjectProperties.this.a.a.ai());
/* 117 */     GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/* 118 */     GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */     
/* 120 */     int x1 = body().x1() + 8;
/*     */     
/* 122 */     m.icon().renderCY(r, x1, body().cY());
/*     */     
/* 124 */     x1 += 20;
/*     */ 
/*     */     
/* 127 */     text.clear();
/* 128 */     text.add(m.name);
/* 129 */     text.setMultipleLines(false);
/* 130 */     text.setMaxWidth(80);
/* 131 */     text.lablify();
/* 132 */     text.renderCY(r, x1, body().cY());
/* 133 */     x1 += 100;
/*     */ 
/*     */ 
/*     */     
/* 137 */     int p = m.has(UISubjectProperties.this.a.a.indu().hType()) ? m.getPriority(UISubjectProperties.this.a.a, (AIManager)UISubjectProperties.this.a.a.ai()) : 0;
/*     */     
/* 139 */     text.clear();
/* 140 */     GFORMAT.iIncr(text, p);
/* 141 */     text.renderCY(r, x1, body().cY());
/*     */ 
/*     */     
/* 144 */     if (!m.has(UISubjectProperties.this.a.a.indu().hType())) {
/* 145 */       OPACITY op = OPACITY.O50;
/* 146 */       op.bind();
/*     */       
/* 148 */       COLOR.BLACK.render(r, (RECTANGLE)this.body, -3);
/* 149 */       OPACITY.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 157 */     GBox b = (GBox)text;
/* 158 */     b.title(m.name);
/* 159 */     if (m.desc != null)
/* 160 */       b.text(m.desc); 
/* 161 */     if (!m.has(UISubjectProperties.this.a.a.indu().hType())) {
/* 162 */       b.add((SPRITE)b.text().warnify().add(UISubjectProperties.¤¤noModule));
/*     */     }
/*     */     
/* 165 */     super.hoverInfoGet(text);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\UISubjectProperties$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */