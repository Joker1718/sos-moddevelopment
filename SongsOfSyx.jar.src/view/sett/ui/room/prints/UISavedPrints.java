/*     */ package view.sett.ui.room.prints;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.copy.SavedPrints;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.STRING_RECIEVER;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import snake2d.util.sprite.text.StringInputSprite;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GInput;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.main.VIEW;
/*     */ import view.tool.PLACABLE;
/*     */ 
/*     */ public final class UISavedPrints extends ISidePanel {
/*  38 */   public static CharSequence ¤¤title = "¤Room Blueprints";
/*     */   static {
/*  40 */     D.ts(UISavedPrints.class);
/*     */   }
/*     */   
/*     */   private final List list;
/*     */   private final GInput filter;
/*  45 */   private final PlacerSave placerSave = new PlacerSave(this);
/*     */   private final GTableBuilder bu;
/*     */   SavedPrints.SavedPrint placing;
/*     */   private SavedPrints.SavedPrint flashed;
/*  49 */   private double flashUntil = 0.0D;
/*     */   
/*     */   private static final int width = 380;
/*     */   private static final int height = 40;
/*     */   
/*     */   public UISavedPrints() {
/*  55 */     titleSet(¤¤title);
/*  56 */     StringInputSprite fi = new StringInputSprite(16, (UI.FONT()).S);
/*  57 */     fi.placeHolder(Dic.¤¤Filter);
/*  58 */     this.filter = new GInput(fi);
/*  59 */     this.list = new List(fi);
/*     */     
/*  61 */     this.section.add((RENDEROBJ)this.filter);
/*     */     
/*  63 */     this.bu = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/*  67 */           return UISavedPrints.this.list.get().size();
/*     */         }
/*     */       };
/*     */     
/*  71 */     this.bu.column(null, 380, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(GETTER<Integer> ier)
/*     */           {
/*  75 */             return (RENDEROBJ)new UISavedPrints.Row(ier);
/*     */           }
/*     */         });
/*     */     
/*  79 */     this.section.addRelBody(8, DIR.S, (RENDEROBJ)this.bu.createHeight(HEIGHT - this.section.body().height() - 8, false));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void open() {
/*  86 */     (VIEW.s()).tools.place((PLACABLE)this.placerSave, this.placerSave.config);
/*  87 */     (VIEW.s()).panels.add(this, true);
/*  88 */     this.flashUntil = 0.0D;
/*  89 */     this.placing = null;
/*     */   }
/*     */   
/*     */   public void open(RoomBlueprint p) {
/*  93 */     for (RoomBlueprint b : SETT.ROOMS().all()) {
/*  94 */       if (b.getClass() == p.getClass() && 
/*  95 */         (SETT.ROOMS()).copy.prints.all(b).size() > 0) {
/*  96 */         (SETT.ROOMS()).copy.savedPlacer.place((SavedPrints.SavedPrint)(SETT.ROOMS()).copy.prints.all(b).get(0), p);
/*  97 */         (VIEW.s()).panels.add(this, true);
/*  98 */         this.flashUntil = 0.0D;
/*  99 */         this.placing = (SavedPrints.SavedPrint)(SETT.ROOMS()).copy.prints.all(b).get(0);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean has(RoomBlueprint p) {
/* 107 */     for (RoomBlueprint b : SETT.ROOMS().all()) {
/*     */       
/* 109 */       if (b.getClass() == p.getClass())
/*     */       {
/* 111 */         if ((SETT.ROOMS()).copy.prints.all(b).size() > 0) {
/* 112 */           return true;
/*     */         }
/*     */       }
/*     */     } 
/* 116 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(SavedPrints.SavedPrint p) {
/* 121 */     this.list.expand(p);
/* 122 */     int li = 0;
/* 123 */     int lastCat = 0;
/* 124 */     for (Entry e : this.list.get()) {
/* 125 */       if (e.print != null && e.print == p) {
/* 126 */         if (li - lastCat < 8)
/* 127 */           li = lastCat; 
/* 128 */         this.bu.set(li);
/* 129 */         this.flashed = p;
/* 130 */         this.flashUntil = VIEW.renderSecond() + 8.0D;
/* 131 */       } else if (e.cat != null) {
/* 132 */         lastCat = li;
/* 133 */       }  li++;
/*     */     } 
/*     */   }
/*     */   
/*     */   public class Row
/*     */     extends CLICKABLE.ClickWrap
/*     */   {
/* 140 */     private final UISavedPrints.RCat cat = new UISavedPrints.RCat();
/* 141 */     private final UISavedPrints.RPrint print = new UISavedPrints.RPrint();
/* 142 */     private final CLICKABLE dum = (CLICKABLE)new CLICKABLE.ClickableAbs(380, 40)
/*     */       {
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {}
/*     */       };
/*     */ 
/*     */ 
/*     */     
/*     */     private final GETTER<Integer> ier;
/*     */ 
/*     */     
/*     */     Row(GETTER<Integer> ier) {
/* 153 */       super(200, 38);
/* 154 */       this.ier = ier;
/*     */     }
/*     */ 
/*     */     
/*     */     protected RENDEROBJ pget() {
/* 159 */       Entry e = (Entry)UISavedPrints.this.list.get().get(((Integer)this.ier.get()).intValue());
/* 160 */       if (e == null)
/* 161 */         return (RENDEROBJ)this.dum; 
/* 162 */       if (e.print != null) {
/* 163 */         this.print.e = e;
/* 164 */         return (RENDEROBJ)this.print;
/*     */       } 
/*     */       
/* 167 */       this.cat.e = e;
/* 168 */       return (RENDEROBJ)this.cat;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public class RCat
/*     */     extends CLICKABLE.ClickableAbs
/*     */   {
/*     */     Entry e;
/*     */ 
/*     */     
/*     */     public RCat() {
/* 181 */       super(380, 40);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 186 */       isActive = (!this.e.isLocked && this.e.cat.entries > 0);
/* 187 */       Cat c = this.e.cat;
/* 188 */       isSelected = c.expanded;
/* 189 */       isHovered = hoveredIs();
/*     */       
/* 191 */       GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)body());
/*     */       
/* 193 */       for (int bi = 0; bi < this.e.cat.prints.size() && bi < 6; bi++) {
/* 194 */         ((RoomBlueprintImp)this.e.cat.prints.get(bi)).iconBig().renderCY(r, this.body.x1() + 8 + bi * 24, this.body.cY());
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 201 */       (UI.FONT()).S.renderCY(r, this.body.x2() - 32 - 48, this.body.cY(), (CharSequence)Str.TMP.clear().add(this.e.cat.entries));
/*     */       
/* 203 */       if (this.e.cat.expanded) {
/* 204 */         (UI.icons()).s.chevron(DIR.S).renderCY(r, this.body.x2() - 32, this.body.cY());
/*     */       } else {
/* 206 */         (UI.icons()).s.chevron(DIR.E).renderCY(r, this.body.x2() - 32, this.body.cY());
/*     */       } 
/* 208 */       if (this.e.cat.entries == 0) {
/* 209 */         OPACITY.O50.bind();
/* 210 */         COLOR.BLACK.render(r, (RECTANGLE)this.body);
/* 211 */         OPACITY.unbind();
/*     */       } 
/*     */       
/* 214 */       GButt.ButtPanel.renderFrame(r, (RECTANGLE)body());
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 219 */       if (this.e.cat.entries > 0) {
/* 220 */         this.e.cat.expanded = !this.e.cat.expanded;
/*     */       }
/*     */     }
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 225 */       GBox b = (GBox)text;
/* 226 */       for (RoomBlueprintImp p : this.e.cat.prints) {
/* 227 */         b.add((SPRITE)p.iconBig());
/* 228 */         b.textLL(p.info.names);
/* 229 */         b.NL();
/*     */       } 
/* 231 */       super.hoverInfoGet(text);
/*     */     }
/*     */   }
/*     */   
/*     */   public class RPrint
/*     */     extends GuiSection
/*     */     implements STRING_RECIEVER {
/*     */     Entry e;
/*     */     
/*     */     public RPrint() {
/* 241 */       body().setDim(16.0D, 40.0D);
/* 242 */       addRightC(4, (SPRITE)new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 246 */               if (UISavedPrints.RPrint.this.e.isLocked) {
/* 247 */                 text.errorify();
/*     */               } else {
/* 249 */                 text.normalify();
/* 250 */               }  text.setMaxWidth(150);
/* 251 */               text.setMultipleLines(false);
/* 252 */               text.add(UISavedPrints.RPrint.this.e.print.name);
/*     */             }
/*     */           });
/* 255 */       addRightCAbs(180, (SPRITE)new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 259 */               text.add(UISavedPrints.RPrint.this.e.print.width).add('x').add(UISavedPrints.RPrint.this.e.print.height);
/*     */             }
/*     */           });
/*     */       
/* 263 */       addRightC(96, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(UI.icons()).s.admin)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 267 */               (VIEW.inters()).input.requestInput(UISavedPrints.RPrint.this, Dic.¤¤rename);
/*     */             }
/* 270 */           }).hoverInfoSet(Dic.¤¤rename));
/* 271 */       addRightC(0, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(UI.icons()).s.cancel)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 275 */               (SETT.ROOMS()).copy.prints.remove(UISavedPrints.RPrint.this.e.print);
/*     */             }
/* 278 */           }).hoverInfoSet(Dic.¤¤remove));
/* 279 */       body().setWidth(380.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 284 */       boolean isActive = !this.e.isLocked;
/* 285 */       boolean isHovered = hoveredIs();
/* 286 */       boolean isSelected = (UISavedPrints.this.placing == this.e.print);
/* 287 */       GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)body());
/* 288 */       super.render(r, ds);
/* 289 */       if (UISavedPrints.this.flashed == this.e.print && UISavedPrints.this.flashUntil > VIEW.renderSecond()) {
/* 290 */         OPACITY.O0To25.bind();
/* 291 */         (GCOLOR.UI()).GOOD.hovered.render(r, (RECTANGLE)body());
/* 292 */         OPACITY.unbind();
/*     */       } 
/*     */       
/* 295 */       GButt.ButtPanel.renderFrame(r, (RECTANGLE)body());
/*     */     }
/*     */ 
/*     */     
/*     */     public void acceptString(CharSequence string) {
/* 300 */       if (this.e != null && string != null && string.length() > 0) {
/* 301 */         this.e.print.name = String.valueOf(string);
/* 302 */         (SETT.ROOMS()).copy.prints.save();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 308 */       if (this.e.isLocked) {
/* 309 */         text.text(Dic.¤¤Locked);
/*     */       }
/* 311 */       text.text(this.e.print.name);
/* 312 */       super.hoverInfoGet(text);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 317 */       for (RoomBlueprintImp b : this.e.cat.prints) {
/* 318 */         if (b.reqs.passes(FACTIONS.player())) {
/* 319 */           (SETT.ROOMS()).copy.savedPlacer.place(this.e.print);
/* 320 */           (VIEW.s()).panels.add(UISavedPrints.this, true);
/* 321 */           UISavedPrints.this.flashUntil = 0.0D;
/* 322 */           UISavedPrints.this.placing = this.e.print;
/*     */           return;
/*     */         } 
/*     */       } 
/* 326 */       super.clickA();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean back() {
/* 333 */     MButt.RIGHT.consumeAllClick();
/* 334 */     MButt.LEFT.consumeAllClick();
/* 335 */     if (this.placing != null) {
/* 336 */       (VIEW.s()).tools.place((PLACABLE)this.placerSave, this.placerSave.config);
/* 337 */       (VIEW.s()).panels.add(this, true);
/* 338 */       this.flashUntil = 0.0D;
/* 339 */       return true;
/*     */     } 
/* 341 */     return super.back();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\prints\UISavedPrints.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */