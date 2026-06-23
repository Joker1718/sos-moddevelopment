/*     */ package settlement.path.components;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HGROUP;
/*     */ import settlement.main.ON_TOP_RENDERABLE;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.main.VIEW;
/*     */ import view.sett.IDebugPanelSett;
/*     */ 
/*     */ final class SCompUI
/*     */   extends ISidePanel
/*     */ {
/*     */   private SComponentLevel l;
/*     */   
/*     */   SCompUI(SCOMPONENTS comps) {
/*  36 */     this.l = comps.zero;
/*     */     
/*  38 */     titleSet("Components");
/*     */     
/*  40 */     IDebugPanelSett.add("Path Comps show", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  44 */             (VIEW.s()).panels.add(SCompUI.this, true);
/*     */           }
/*     */         });
/*     */     
/*  48 */     int i = 0;
/*  49 */     for (SComponentLevel l : comps.all) {
/*     */ 
/*     */       
/*  52 */       GButt.Panel panel = new GButt.Panel((UI.FONT()).M.getText("" + i))
/*     */         {
/*     */           protected void clickA()
/*     */           {
/*  56 */             SCompUI.this.l = l;
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/*  61 */             selectedSet((SCompUI.this.l == l));
/*     */           }
/*     */         };
/*  64 */       this.section.addRightC(2, (RENDEROBJ)panel);
/*  65 */       i++;
/*     */     } 
/*     */     
/*  68 */     this.section.body().setWidth(600.0D);
/*     */ 
/*     */ 
/*     */     
/*  72 */     this.section.add((RENDEROBJ)new view(comps), this.section.body().x1() + 10, this.section.body().y2() + 4);
/*     */   }
/*     */ 
/*     */   
/*     */   private class view
/*     */     extends GuiSection
/*     */   {
/*  79 */     private SComponent comp = null;
/*  80 */     ON_TOP_RENDERABLE rr = new ON_TOP_RENDERABLE()
/*     */       {
/*     */         public void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds)
/*     */         {
/*  84 */           RenderData.RenderIterator it = data.onScreenTiles();
/*  85 */           SComponentLevel prev = (SCompUI.view.access$0(SCompUI.view.this)).l;
/*  86 */           SComponentLevel current = (SCompUI.view.access$0(SCompUI.view.this)).l;
/*     */           
/*  88 */           if ((SCompUI.view.access$0(SCompUI.view.this)).l.level() > 0) {
/*  89 */             prev = (SComponentLevel)(SETT.PATH()).comps.all.get((SCompUI.view.access$0(SCompUI.view.this)).l.level() - 1);
/*     */           }
/*     */           
/*  92 */           while (it.has()) {
/*  93 */             SComponent c = (SComponent)prev.get(it.tile());
/*  94 */             if (c != null) {
/*  95 */               int m = 0;
/*  96 */               for (DIR d : DIR.ORTHO) {
/*  97 */                 if (c.is(it.tx(), it.ty(), d))
/*  98 */                   m |= d.mask(); 
/*     */               } 
/* 100 */               SComponent cc = (SComponent)current.get(it.tile());
/* 101 */               if (cc != null) {
/* 102 */                 if (cc == SCompUI.view.this.comp) {
/* 103 */                   COLOR.WHITE100.bind();
/*     */                 } else {
/* 105 */                   ((COLOR)COLOR.UNIQUE.getC(cc.index())).bind();
/* 106 */                 }  if (m != 15)
/* 107 */                   (SPRITES.cons()).BIG.dashed_hollow.render((SPRITE_RENDERER)r, m, it.x(), it.y()); 
/* 108 */                 if (it.tx() == cc.centreX() && it.ty() == cc.centreY()) {
/* 109 */                   (SPRITES.cons()).ICO.crosshair.render((SPRITE_RENDERER)r, it.x(), it.y());
/*     */                 }
/*     */               } 
/*     */             } 
/*     */ 
/*     */ 
/*     */             
/* 116 */             it.next();
/*     */           } 
/* 118 */           COLOR.unbind();
/* 119 */           remove();
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/*     */     view(SCOMPONENTS comps) {
/* 126 */       addRelBody(8, DIR.S, (SPRITE)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 130 */               text.lablify();
/* 131 */               text.add(SCompUI.view.this.comp.index());
/* 132 */               text.s();
/*     */               
/* 134 */               if (SCompUI.view.this.comp.hasEdge()) {
/* 135 */                 text.s();
/* 136 */                 text.add('b');
/*     */               } 
/* 138 */               if (SCompUI.view.this.comp.hasEntry()) {
/* 139 */                 text.s();
/* 140 */                 text.add('e');
/*     */               } 
/*     */               
/* 143 */               text.s().s().add('s');
/* 144 */               if (SCompUI.view.this.comp.superComp() != null) {
/* 145 */                 text.s().add(SCompUI.view.this.comp.superComp().index());
/*     */               }
/* 147 */               text.s().s().s();
/* 148 */               text.add('(').add(VIEW.s().getWindow().tile().x()).s().add(VIEW.s().getWindow().tile().y()).add(')');
/* 149 */               text.s().add(SCompUI.view.this.comp.retired());
/*     */             }
/* 151 */           }).increase());
/*     */       
/* 153 */       add((RENDEROBJ)new RENDEROBJ.RenderImp(600, 48)
/*     */           {
/* 155 */             private final GText t = new GText((UI.FONT()).S, "");
/*     */ 
/*     */             
/*     */             public void render(SPRITE_RENDERER r, float ds) {
/* 159 */               int i = 0;
/* 160 */               COLOR.WHITE100.render(r, (RECTANGLE)body());
/* 161 */               SComponentEdge e = SCompUI.view.this.comp.edgefirst();
/* 162 */               while (e != null) {
/* 163 */                 this.t.clear();
/* 164 */                 this.t.color((COLOR)COLOR.UNIQUE.getC(e.to().index()));
/* 165 */                 this.t.add(e.to().index());
/* 166 */                 this.t.add('-').add('>');
/* 167 */                 this.t.add((int)e.distance());
/* 168 */                 this.t.add('|');
/* 169 */                 this.t.add((int)e.cost2());
/* 170 */                 this.t.s().s();
/* 171 */                 this.t.render(r, body().x1() + i % 5 * 120, body().y1() + i / 5 * 16);
/* 172 */                 e = e.next();
/* 173 */                 i++;
/*     */               } 
/*     */             }
/* 176 */           }0, body().y2() + 4);
/*     */ 
/*     */       
/* 179 */       add((SPRITE)new GText((UI.FONT()).H2, ""), 0, getLastY2() + 32);
/* 180 */       int tab = 90;
/* 181 */       for (FindableDataRes r : FindableDataRes.all) {
/* 182 */         addRightCAbs(tab, (SPRITE)new GText((UI.FONT()).H2, r.title));
/*     */       }
/* 184 */       RENDEROBJ[] arrayOfRENDEROBJ1 = new RENDEROBJ[RESOURCES.ALL().size()];
/* 185 */       for (RESOURCE res : RESOURCES.ALL()) {
/* 186 */         GuiSection section = new GuiSection();
/* 187 */         section.hoverInfoSet(res.name);
/* 188 */         section.add((res.icon()).small, 0, section.getLastY2());
/* 189 */         for (FindableDataRes r : FindableDataRes.all) {
/* 190 */           GStat s = new GStat()
/*     */             {
/*     */               public void update(GText text)
/*     */               {
/* 194 */                 text.add(r.get(SCompUI.view.this.comp, res));
/* 195 */                 text.add(r.bits(SCompUI.view.this.comp).has(res) ? 42 : 32);
/* 196 */                 text.normalify();
/* 197 */                 if (r.get(SCompUI.view.this.comp, res) > 0)
/* 198 */                   text.lablify(); 
/* 199 */                 if (r.overflow(SCompUI.view.this.comp, res)) {
/* 200 */                   text.add('!');
/*     */                 }
/*     */               }
/*     */             };
/*     */           
/* 205 */           section.addRightCAbs(tab, (SPRITE)s);
/*     */         } 
/* 207 */         section.body().incrW(80.0D);
/* 208 */         arrayOfRENDEROBJ1[res.index()] = (RENDEROBJ)section;
/*     */       } 
/* 210 */       add((RENDEROBJ)(new GScrollRows(arrayOfRENDEROBJ1, SCompUI.HEIGHT / 3, 0)).view(), 0, getLastY2() + 2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 216 */       RENDEROBJ[] rows = new RENDEROBJ[FindableDataSingle.all.size()];
/*     */       
/* 218 */       int i = 0;
/* 219 */       for (FindableData d : FindableDataSingle.all) {
/* 220 */         rows[i++] = (RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 224 */               if (SCompUI.view.this.comp != null) {
/* 225 */                 text.add(d.get(SCompUI.view.this.comp));
/* 226 */                 if (d.overflow(SCompUI.view.this.comp)) {
/* 227 */                   text.add('!');
/*     */                 }
/*     */               } 
/*     */             }
/* 231 */           }).hh(d.name, 200);
/*     */       } 
/* 233 */       add((RENDEROBJ)(new GScrollRows(rows, SCompUI.HEIGHT - getLastY2() - 64, 0)).view(), 0, getLastY2() + 2);
/*     */ 
/*     */ 
/*     */       
/* 237 */       rows = new RENDEROBJ[HGROUP.all().size()];
/*     */       
/* 239 */       i = 0;
/* 240 */       for (HGROUP t : HGROUP.all()) {
/* 241 */         rows[i++] = (RENDEROBJ)(new GStat(comps, t) {
/*     */             FindableData d;
/*     */             
/*     */             public void update(GText text) {
/* 245 */               if (SCompUI.view.this.comp != null) {
/* 246 */                 text.add(this.d.get(SCompUI.view.this.comp));
/* 247 */                 if (this.d.overflow(SCompUI.view.this.comp)) {
/* 248 */                   text.add('!');
/*     */                 }
/*     */               } 
/*     */             }
/* 252 */           }).hh((comps.data.home.get(t)).name, 250);
/*     */       } 
/* 254 */       add((RENDEROBJ)(new GScrollRows(rows, SCompUI.HEIGHT - getLastY1() - 64, 0)).view(), getLastX2() + 10, getLastY1());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 262 */       this.rr.add();
/* 263 */       if (VIEW.mouse().x() > 600) {
/* 264 */         this.comp = (SComponent)SCompUI.this.l.get((COORDINATE)VIEW.s().getWindow().tile());
/*     */       }
/* 266 */       if (this.comp == null) {
/*     */         return;
/*     */       }
/* 269 */       super.render(r, ds);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\components\SCompUI.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */