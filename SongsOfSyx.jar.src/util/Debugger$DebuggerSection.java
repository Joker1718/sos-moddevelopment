/*     */ package util;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayListResize;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import snake2d.util.sprite.text.StringInputSprite;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GInput;
/*     */ import util.gui.table.GTableBuilder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class DebuggerSection
/*     */   extends GuiSection
/*     */ {
/* 172 */   private final ArrayListResize<Debugger.Row> filtered = new ArrayListResize(128);
/* 173 */   public final Debugger.Live debugger = new Debugger.Live();
/* 174 */   private final GInput sp = new GInput(new StringInputSprite(24, (UI.FONT()).S));
/*     */ 
/*     */ 
/*     */   
/*     */   public DebuggerSection(int height) {
/* 179 */     GTableBuilder bu = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries() {
/* 182 */           return Debugger.DebuggerSection.this.filtered.size();
/*     */         }
/*     */         
/*     */         public void click(int index) {
/* 186 */           if (((Debugger.Row)Debugger.DebuggerSection.this.filtered.get(index)).a != null) {
/* 187 */             ((Debugger.Row)Debugger.DebuggerSection.this.filtered.get(index)).a.exe();
/*     */           }
/*     */         }
/*     */       };
/*     */     
/* 192 */     bu.column(null, 800, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 196 */             return (RENDEROBJ)new RENDEROBJ.RenderImp(800, 24)
/*     */               {
/*     */                 public void render(SPRITE_RENDERER r, float ds)
/*     */                 {
/* 200 */                   Debugger.Row row = (Debugger.Row)(Debugger.DebuggerSection.null.access$0(Debugger.DebuggerSection.null.this)).filtered.get(((Integer)ier.get()).intValue());
/* 201 */                   int x1 = this.body.x1() + row.indent * 10;
/* 202 */                   if (row.name == null) {
/* 203 */                     (GCOLOR.T()).H1.bind();
/* 204 */                     (UI.FONT()).S.renderCY(r, x1, this.body.cY(), (CharSequence)row.str);
/*     */                   } else {
/* 206 */                     (GCOLOR.T()).H2.bind();
/* 207 */                     (UI.FONT()).S.renderCY(r, x1, this.body.cY(), row.name);
/* 208 */                     COLOR.unbind();
/* 209 */                     (UI.FONT()).S.renderCY(r, x1 + 400, this.body.cY(), (CharSequence)row.str);
/*     */                   } 
/* 211 */                   COLOR.unbind();
/*     */                 }
/*     */               };
/*     */           }
/*     */         });
/*     */     
/* 217 */     add((RENDEROBJ)bu.createHeight(height - 8 - this.sp.body().height(), true));
/*     */     
/* 219 */     addRelBody(8, DIR.N, (RENDEROBJ)this.sp);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 225 */     super.render(r, ds);
/* 226 */     this.debugger.clear();
/* 227 */     fill(this.debugger);
/* 228 */     this.filtered.clearSoft();
/*     */     
/* 230 */     if (this.sp.text() == null || this.sp.text().length() == 0) {
/* 231 */       this.filtered.add((Iterable)this.debugger.all);
/*     */     } else {
/* 233 */       for (Debugger.Row rr : this.debugger.all) {
/* 234 */         if (this.sp.text() == null || this.sp.text().length() == 0) {
/* 235 */           this.filtered.add(rr); continue;
/* 236 */         }  if (rr.name != null && Str.containsText(rr.name, (CharSequence)this.sp.text())) {
/* 237 */           this.filtered.add(rr); continue;
/* 238 */         }  if (Str.containsText((CharSequence)rr.str, (CharSequence)this.sp.text()))
/* 239 */           this.filtered.add(rr); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected abstract void fill(Debugger paramDebugger);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\Debugger$DebuggerSection.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */