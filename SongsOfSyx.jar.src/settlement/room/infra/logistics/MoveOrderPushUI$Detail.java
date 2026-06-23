/*     */ package settlement.room.infra.logistics;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Detail
/*     */ {
/*     */   private MoveOrderPush o;
/* 137 */   private final GuiSection section = new GuiSection();
/*     */   
/*     */   private int oi;
/*     */   
/*     */   Detail(final MoveOrderPushUI.Placer placer) {
/* 142 */     this.section.add((RENDEROBJ)(new HOVERABLE.Sprite(placer.getIcon())).hoverInfoSet(placer.name()), 0, this.section.body().y2() + 4);
/* 143 */     this.section.addRightCAbs(48, (RENDEROBJ)new CLICKABLE.ClickableAbs(200, 32)
/*     */         {
/* 145 */           final GText t = new GText((UI.FONT()).S, 24);
/*     */ 
/*     */           
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 149 */             GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/* 150 */             this.t.setMaxWidth(180);
/* 151 */             this.t.setMultipleLines(false);
/* 152 */             this.t.clear();
/* 153 */             this.t.normalify();
/* 154 */             if (MoveOrderPushUI.Detail.this.o.dest() == null) {
/* 155 */               this.t.add(MoveOrderPushUI.¤¤notSet);
/* 156 */               this.t.errorify();
/*     */             } else {
/* 158 */               this.t.add((CharSequence)MoveOrderPushUI.Detail.this.o.destI().name());
/*     */             } 
/* 160 */             this.t.adjustWidth();
/* 161 */             this.t.renderC(r, (RECTANGLE)this.body);
/* 162 */             GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 167 */             text.title(placer.name());
/* 168 */             if (MoveOrderPushUI.Detail.this.o.dest() == null) {
/* 169 */               text.text(MoveOrderPushUI.¤¤notSetC);
/*     */             } else {
/* 171 */               text.text(MoveOrderPushUI.¤¤setC);
/*     */             } 
/* 173 */             super.hoverInfoGet(text);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 178 */             if (MoveOrderPushUI.Detail.this.o.dest() == null) {
/* 179 */               placer.activate(MoveOrderPushUI.Detail.this.oi);
/*     */             } else {
/* 181 */               (VIEW.s().getWindow()).centererTile.set(MoveOrderPushUI.Detail.this.o.destI().body().cX(), MoveOrderPushUI.Detail.this.o.destI().body().cY());
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 188 */     RENDEROBJ.RenderImp renderImp = new RENDEROBJ.RenderImp(300, 64) {
/* 189 */         GText t = new GText((UI.FONT()).S, 128);
/*     */ 
/*     */         
/*     */         public void render(SPRITE_RENDERER r, float ds) {
/* 193 */           this.t.clear();
/* 194 */           this.t.setMultipleLines(true);
/* 195 */           this.t.setMaxWidth(280);
/* 196 */           if (MoveOrderPushUI.Detail.this.o.problem((MoveOrderPush.MoveOrderPushInstance)(MoveOrderPushUI.Detail.access$0(MoveOrderPushUI.Detail.this)).source.get()) != null) {
/* 197 */             this.t.add(MoveOrderPushUI.Detail.this.o.problem((MoveOrderPush.MoveOrderPushInstance)(MoveOrderPushUI.Detail.access$0(MoveOrderPushUI.Detail.this)).source.get()));
/* 198 */             this.t.errorify();
/* 199 */           } else if (MoveOrderPushUI.Detail.this.o.warning((MoveOrderPush.MoveOrderPushInstance)(MoveOrderPushUI.Detail.access$0(MoveOrderPushUI.Detail.this)).source.get()) != null) {
/* 200 */             this.t.add(MoveOrderPushUI.Detail.this.o.warning((MoveOrderPush.MoveOrderPushInstance)(MoveOrderPushUI.Detail.access$0(MoveOrderPushUI.Detail.this)).source.get()));
/* 201 */             this.t.warnify();
/*     */           } 
/* 203 */           this.t.adjustWidth();
/* 204 */           this.t.render(r, this.body.x1(), this.body.y1());
/*     */         }
/*     */       };
/* 207 */     this.section.add((RENDEROBJ)renderImp, 0, this.section.body().y2() + 4);
/*     */ 
/*     */     
/* 210 */     INT.INTE ii = new INT.INTE()
/*     */       {
/*     */         public int min()
/*     */         {
/* 214 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 219 */           return 50;
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 224 */           return MoveOrderPushUI.Detail.this.o.limit / 2;
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 229 */           MoveOrderPushUI.Detail.this.o.limit = (byte)(t * 2);
/*     */         }
/*     */       };
/*     */     
/* 233 */     GSliderInt sl = new GSliderInt(ii, 160, false)
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text)
/*     */         {
/* 237 */           GBox b = (GBox)text;
/* 238 */           b.title(MoveOrderPushUI.¤¤Limit);
/* 239 */           b.text(MoveOrderPushUI.¤¤LimitD);
/*     */ 
/*     */           
/* 242 */           b.NL();
/* 243 */           b.add((SPRITE)GFORMAT.perc(b.text(), MoveOrderPushUI.Detail.this.o.limit / 100.0D));
/* 244 */           b.NL();
/*     */           
/* 246 */           if (MoveOrderPushUI.Detail.this.o.dest() != null) {
/* 247 */             for (RESOURCE res : RESOURCES.ALL()) {
/* 248 */               if (MoveOrderPushUI.Detail.this.o.dest().moveCapacity().has(res) && ((MoveOrderPush.MoveOrderPushInstance)(MoveOrderPushUI.Detail.access$0(MoveOrderPushUI.Detail.this)).source.get()).moveOrderPushAvailable().has(res)) {
/* 249 */                 double am = MoveOrderPushUI.Detail.this.o.dest().storedD(res);
/* 250 */                 b.add((SPRITE)res.icon());
/* 251 */                 b.add((SPRITE)GFORMAT.perc(b.text(), am));
/* 252 */                 b.NL();
/*     */               } 
/*     */             } 
/*     */           }
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 260 */     sl.addRelBody(8, DIR.W, (RENDEROBJ)new GHeader(MoveOrderPushUI.¤¤Limit));
/*     */     
/* 262 */     this.section.addRelBody(6, DIR.S, (RENDEROBJ)sl);
/*     */     
/* 264 */     this.section.addRelBody(8, DIR.S, (RENDEROBJ)new GButt.ButtPanel(Dic.¤¤remove)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 268 */             ((MoveOrderPush.MoveOrderPushInstance)(MoveOrderPushUI.Detail.access$0(MoveOrderPushUI.Detail.this)).source.get()).moveOrdersPush()[MoveOrderPushUI.Detail.this.oi] = null;
/* 269 */             (VIEW.inters()).popup.close();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public GuiSection get(int oi) {
/* 276 */     this.oi = oi;
/* 277 */     this.o = ((MoveOrderPush.MoveOrderPushInstance)MoveOrderPushUI.this.source.get()).moveOrdersPush()[oi];
/* 278 */     return this.section;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\logistics\MoveOrderPushUI$Detail.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */