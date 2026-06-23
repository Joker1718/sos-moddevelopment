/*     */ package game.events.advice;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import view.main.VIEW;
/*     */ import view.sett.UISettMap;
/*     */ import view.ui.message.MessageSection;
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
/*     */ class MessageHighlight
/*     */   extends MessageSection
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final String UIKey;
/*     */   private final String body;
/*     */   
/*     */   public MessageHighlight(CharSequence title, CharSequence body, String UIKey) {
/* 188 */     super(String.valueOf(EventAdvisor.¤¤Advice) + String.valueOf(EventAdvisor.¤¤Advice));
/* 189 */     this.UIKey = UIKey;
/* 190 */     this.body = String.valueOf(body);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void make(final GuiSection section) {
/* 195 */     paragraph(this.body);
/*     */     
/* 197 */     section.addDown(0, (RENDEROBJ)new RENDEROBJ.RenderImp(0) {
/* 198 */           final RENDEROBJ o = UISettMap.getByKey(EventAdvisor.MessageHighlight.this.UIKey);
/*     */           
/*     */           public void render(SPRITE_RENDERER r, float ds) {
/* 201 */             EventAdvisor.MessageHighlight.highlight(section, r, this.o);
/* 202 */             if (!VIEW.s().isActive()) {
/* 203 */               VIEW.s().activate();
/*     */             }
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   private static void highlight(GuiSection s, SPRITE_RENDERER r, RENDEROBJ o) {
/* 210 */     COLOR c = COLOR.RED2RED;
/*     */     
/* 212 */     c.render(r, o.body().x1() - 8, o.body().x2() + 8, o.body().y1() - 8, o.body().y1() - 4);
/* 213 */     c.render(r, o.body().x1() - 8, o.body().x2() + 8, o.body().y2() + 8, o.body().y2() + 4);
/* 214 */     c.render(r, o.body().x1() - 8, o.body().x1() - 4, o.body().y1() - 8, o.body().y2() + 8);
/* 215 */     c.render(r, o.body().x2() + 4, o.body().x2() + 8, o.body().y1() - 8, o.body().y2() + 8);
/*     */ 
/*     */ 
/*     */     
/* 219 */     if (o.body().cX() < s.body().cX()) {
/* 220 */       c.render(r, o.body().x2() + 4, s.body().cX() + 4, o.body().cY() - 4, o.body().cY() + 4);
/*     */     } else {
/* 222 */       c.render(r, o.body().x1() - 4, s.body().cX() + 4, o.body().cY() - 4, o.body().cY() + 4);
/*     */     } 
/*     */     
/* 225 */     int y1 = s.body().y1() - 80;
/* 226 */     int y2 = s.body().y2();
/*     */     
/* 228 */     if (o.body().y2() < y1) {
/* 229 */       c.render(r, s.body().cX() - 4, s.body().cX() + 4, o.body().cY(), y1);
/*     */     } else {
/* 231 */       c.render(r, s.body().cX() - 4, s.body().cX() + 4, o.body().cY(), y2);
/*     */     } 
/*     */ 
/*     */     
/* 235 */     OPACITY.unbind();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\advice\EventAdvisor$MessageHighlight.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */