/*     */ package view.ui.goods;
/*     */ 
/*     */ import game.faction.Faction;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.Icon;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import snake2d.util.sprite.text.StringInputSprite;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GInput;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.ui.manage.IFullView;
/*     */ 
/*     */ public final class UIGoods extends IFullView {
/*     */   private static final int COLS = 2;
/*  33 */   private final ArrayList<Object> all = new ArrayList(RESOURCES.ALL().size() * 2 + 1);
/*     */   
/*  35 */   public final Icon icon = (Icon)(SPRITES.icons()).s.storage;
/*  36 */   private static CharSequence ¤¤Name = "¤Goods";
/*     */   
/*     */   static {
/*  39 */     D.ts(UIGoods.class);
/*     */   }
/*     */   
/*     */   private final GTableBuilder bu;
/*     */   private RESOURCE flashRes;
/*     */   private double flashTime;
/*  45 */   private final GInput filter = new GInput((new StringInputSprite(24, (UI.FONT()).S)).placeHolder(Dic.¤¤Search));
/*     */ 
/*     */ 
/*     */   
/*     */   public UIGoods() {
/*  50 */     super(¤¤Name, (SPRITE)(UI.icons()).l.crate);
/*     */     
/*  52 */     this.section = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER ren, float ds)
/*     */         {
/*  56 */           UIGoods.this.update();
/*  57 */           super.render(ren, ds);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  62 */     this.section.body().setWidth(WIDTH).setHeight(1.0D);
/*  63 */     this.section.addRelBody(8, DIR.S, (RENDEROBJ)this.filter);
/*     */     
/*  65 */     this.bu = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/*  69 */           return (int)Math.ceil(UIGoods.this.all.size() / 2.0D);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  74 */     final Pop pop = new Pop();
/*  75 */     int wi = (new Entry(null, 0, pop)).body().width();
/*  76 */     this.bu.column(null, wi, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(GETTER<Integer> ier)
/*     */           {
/*  80 */             return (RENDEROBJ)new UIGoods.Entry(ier, 0, pop);
/*     */           }
/*     */         });
/*  83 */     this.bu.column(null, wi, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(GETTER<Integer> ier)
/*     */           {
/*  87 */             return (RENDEROBJ)new UIGoods.Entry(ier, 1, pop);
/*     */           }
/*     */         });
/*     */     
/*  91 */     this.section.addRelBody(8, DIR.S, (RENDEROBJ)this.bu.createHeight(HEIGHT - this.section.body().height() - 8, false));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void update() {
/*  98 */     this.all.clearSloppy();
/*     */     
/* 100 */     Str str = this.filter.text();
/*     */     
/* 102 */     if (str.length() == 0 || Str.containsText(Dic.¤¤Total, (CharSequence)str)) {
/* 103 */       this.all.add(null);
/*     */     }
/* 105 */     int cat = ((RESOURCE)RESOURCES.ALL().get(0)).category;
/* 106 */     for (RESOURCE r : RESOURCES.ALL()) {
/* 107 */       if (str.length() == 0 || Str.containsText(r.name, (CharSequence)str) || Str.containsText(r.names, (CharSequence)str)) {
/* 108 */         if (r.category != cat) {
/* 109 */           if ((this.all.size() & 0x1) == 1)
/* 110 */             this.all.add(this.icon); 
/* 111 */           cat = r.category;
/*     */         } 
/*     */         
/* 114 */         this.all.add(r);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void detail(RESOURCE res, Faction f) {
/* 123 */     activate();
/* 124 */     int ta = this.all.indexOf(res);
/* 125 */     if (ta == -1) {
/* 126 */       ta = 0;
/*     */     }
/* 128 */     this.bu.set(ta / 2);
/* 129 */     this.flashRes = res;
/* 130 */     this.flashTime = VIEW.renderSecond();
/*     */   }
/*     */ 
/*     */   
/*     */   public void activate() {
/* 135 */     this.flashRes = null;
/* 136 */     this.filter.text().clear();
/* 137 */     this.filter.focus();
/* 138 */     update();
/* 139 */     super.activate();
/*     */   }
/*     */   
/*     */   private class Entry
/*     */     extends GuiSection
/*     */   {
/*     */     private final GETTER<Integer> ier;
/*     */     private final GETTER<RESOURCE> res;
/*     */     private final int off;
/*     */     
/*     */     Entry(final GETTER<Integer> ier, final int off, Pop pop) {
/* 150 */       this.off = off;
/* 151 */       this.ier = ier;
/* 152 */       this.res = new GETTER<RESOURCE>()
/*     */         {
/*     */           public RESOURCE get()
/*     */           {
/* 156 */             int i = ((Integer)ier.get()).intValue() * 2 + off;
/* 157 */             if (i >= (UIGoods.Entry.access$0(UIGoods.Entry.this)).all.size() || (UIGoods.Entry.access$0(UIGoods.Entry.this)).all.get(i) == null || (UIGoods.Entry.access$0(UIGoods.Entry.this)).all.get(i) == (UIGoods.Entry.access$0(UIGoods.Entry.this)).icon)
/* 158 */               return null; 
/* 159 */             return (RESOURCE)(UIGoods.Entry.access$0(UIGoods.Entry.this)).all.get(i);
/*     */           }
/*     */         };
/*     */ 
/*     */ 
/*     */       
/* 165 */       addRightCAbs(56, (RENDEROBJ)new Row(this.res, pop));
/*     */ 
/*     */ 
/*     */       
/* 169 */       addRelBody(2, DIR.S, (RENDEROBJ)new RENDEROBJ.RenderImp(body().width(), 6)
/*     */           {
/*     */             public void render(SPRITE_RENDERER r, float ds)
/*     */             {
/* 173 */               GCOLOR.UI().border().render(r, body().x1(), body().x2(), body().cY(), body().cY() + 1);
/*     */             }
/*     */           });
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 180 */       pad(6, 0);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER rr, float ds) {
/* 187 */       int i = ((Integer)this.ier.get()).intValue() * 2 + this.off;
/* 188 */       if (i >= UIGoods.this.all.size() || UIGoods.this.all.get(i) == UIGoods.this.icon) {
/*     */         return;
/*     */       }
/* 191 */       if (this.res.get() != null && UIGoods.this.flashRes == this.res.get() && VIEW.renderSecond() - UIGoods.this.flashTime < 3.0D) {
/* 192 */         COLOR.WHITE2WHITE.render(rr, (RECTANGLE)body(), -1);
/*     */       
/*     */       }
/* 195 */       else if (hoveredIs()) {
/* 196 */         OPACITY.O012.bind();
/* 197 */         COLOR.WHITE100.render(rr, (RECTANGLE)body(), -1);
/* 198 */         OPACITY.unbind();
/*     */       } 
/* 200 */       super.render(rr, ds);
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 205 */       text.title((this.res.get() == null) ? Dic.¤¤Total : ((RESOURCE)this.res.get()).name);
/* 206 */       super.hoverInfoGet(text);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hover(COORDINATE mCoo) {
/* 211 */       int i = ((Integer)this.ier.get()).intValue() * 2 + this.off;
/* 212 */       if (i >= UIGoods.this.all.size() || UIGoods.this.all.get(i) == UIGoods.this.icon)
/* 213 */         return false; 
/* 214 */       return super.hover(mCoo);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\goods\UIGoods.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */