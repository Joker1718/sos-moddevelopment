/*     */ package view.sett.ui.home;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HGROUP;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ final class UIHomesTable
/*     */   extends GuiSection
/*     */ {
/*  31 */   private static CharSequence ¤¤Housed = "¤Housed";
/*  32 */   private static CharSequence ¤¤HousedD = "¤Subjects that have a home. There might be a small delay between building new houses and having people move in.";
/*  33 */   private static CharSequence ¤¤Homeless = "¤Homeless";
/*  34 */   private static CharSequence ¤¤HomelessD = "¤Subjects that have looked for housing, yet have not found one. Oddjobbers will search for houses across the whole map. Employed people will search in the vicinity of their workplace.";
/*  35 */   private static CharSequence ¤¤HousingTotal = "¤Total Housing";
/*  36 */   private static CharSequence ¤¤HousingAvailable = "¤Available Housing";
/*  37 */   private static CharSequence ¤¤HousingAvailableD = "¤Available Housing of this type across the map. Note that these houses might be beyond the reach of employed people.";
/*  38 */   private static CharSequence ¤¤ClickToGoToFirstHomeless = "¤Click to go to a subject that has trouble finding a home.";
/*  39 */   private static CharSequence ¤¤FurnishClick = "¤Click to manage furnishing.";
/*     */   
/*     */   Humanoid subject;
/*  42 */   private int hi = 0;
/*     */   
/*     */   static {
/*  45 */     D.ts(UIHomesTable.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public UIHomesTable(int HEIGHT) {
/*  50 */     final Data housed = new Data(¤¤Housed, ¤¤HousedD)
/*     */       {
/*     */         GText format(GText t, HGROUP h)
/*     */         {
/*  54 */           return GFORMAT.i(t, (STATS.HOME()).GETTER.stat().data(h.type).get(h.race));
/*     */         }
/*     */       };
/*     */     
/*  58 */     final Data homeless = new Data(¤¤Homeless, ¤¤HomelessD)
/*     */       {
/*     */         GText format(GText t, HGROUP h)
/*     */         {
/*  62 */           int am = (STATS.HOME()).GETTER.hasSearched.data(h.type).get(h.race);
/*  63 */           GFORMAT.i(t, am);
/*  64 */           if (am > 0)
/*  65 */             t.errorify(); 
/*  66 */           return t;
/*     */         }
/*     */       };
/*     */     
/*  70 */     final Data available = new Data(¤¤HousingAvailable, ¤¤HousingAvailableD)
/*     */       {
/*     */         
/*     */         GText format(GText t, HGROUP h)
/*     */         {
/*  75 */           int am = (SETT.ROOMS()).HOME.total(h) - (SETT.ROOMS()).HOME.used(h);
/*     */ 
/*     */           
/*  78 */           return GFORMAT.i(t, am);
/*     */         }
/*     */       };
/*     */     
/*  82 */     final Data total = new Data(¤¤HousingTotal, "")
/*     */       {
/*     */         GText format(GText t, HGROUP h)
/*     */         {
/*  86 */           int am = (SETT.ROOMS()).HOME.total(h);
/*     */ 
/*     */           
/*  89 */           return GFORMAT.i(t, am);
/*     */         }
/*     */       };
/*     */     
/*  93 */     final Data furnishing = new Data(((STATS.HOME()).materials.info()).name, ((STATS.HOME()).materials.info()).desc)
/*     */       {
/*     */         GText format(GText t, HGROUP h)
/*     */         {
/*  97 */           return GFORMAT.perc(t, (STATS.HOME()).materials.data(h.type).getD(h.race));
/*     */         }
/*     */       };
/*     */     
/* 101 */     GTableBuilder bu = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/* 105 */           return HGROUP.all().size();
/*     */         }
/*     */         
/*     */         private void hover(GBox box, HGROUP h, UIHomesTable.Data d) {
/* 109 */           box.textL(d.name);
/* 110 */           box.tab(5);
/* 111 */           box.add((SPRITE)d.format(box.text(), h));
/* 112 */           box.NL();
/* 113 */           box.text(d.desc);
/* 114 */           box.NL(4);
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfo(int index, GBox box) {
/* 119 */           HGROUP h = (HGROUP)HGROUP.all().get(index);
/* 120 */           box.title(h.name);
/*     */           
/* 122 */           hover(box, h, homeless);
/* 123 */           hover(box, h, housed);
/* 124 */           hover(box, h, available);
/* 125 */           hover(box, h, total);
/* 126 */           hover(box, h, furnishing);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean activeIs(int index) {
/* 132 */           HGROUP h = (HGROUP)HGROUP.all().get(index);
/* 133 */           return ((STATS.POP()).POP.data(h.type).get(h.race) > 0);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 138 */     int size = 90;
/*     */     
/* 140 */     GTableBuilder.GRowBuilder b = new GTableBuilder.GRowBuilder()
/*     */       {
/*     */         public RENDEROBJ build(final GETTER<Integer> ier)
/*     */         {
/* 144 */           return (RENDEROBJ)new HOVERABLE.Sprite(28)
/*     */             {
/*     */               protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 147 */                 HGROUP h = (HGROUP)HGROUP.all().get(((Integer)ier.get()).intValue());
/* 148 */                 h.icon.render(r, this.body.x1() + 2, body().y1() + 2);
/*     */               }
/*     */             };
/*     */         }
/*     */       };
/* 153 */     bu.column(null, 48, b);
/*     */     
/* 155 */     bu.column(homeless.name, size, row(homeless));
/* 156 */     bu.column(housed.name, size, row(housed));
/*     */     
/* 158 */     b = new GTableBuilder.GRowBuilder()
/*     */       {
/*     */         
/*     */         public RENDEROBJ build(final GETTER<Integer> ier)
/*     */         {
/* 163 */           final GStat a = new GStat()
/*     */             {
/*     */               
/*     */               public void update(GText text)
/*     */               {
/* 168 */                 HGROUP h = (HGROUP)HGROUP.all().get(((Integer)ier.get()).intValue());
/* 169 */                 available.format(text, h);
/*     */               }
/*     */             };
/* 172 */           final GStat b = new GStat()
/*     */             {
/*     */               public void update(GText text)
/*     */               {
/* 176 */                 text.add('(');
/* 177 */                 HGROUP h = (HGROUP)HGROUP.all().get(((Integer)ier.get()).intValue());
/* 178 */                 total.format(text, h);
/* 179 */                 text.add(')');
/*     */               }
/*     */             };
/*     */           
/* 183 */           return (RENDEROBJ)new RENDEROBJ.RenderImp(20, b.height())
/*     */             {
/*     */               public void render(SPRITE_RENDERER r, float ds)
/*     */               {
/* 187 */                 a.render(r, body().x1(), body().y1());
/* 188 */                 b.render(r, body().x1() + 60, body().y1());
/*     */               }
/*     */             };
/*     */         }
/*     */       };
/* 193 */     bu.column(Dic.¤¤Available, size + 40, b);
/*     */     
/* 195 */     b = new GTableBuilder.GRowBuilder()
/*     */       {
/*     */         
/*     */         public RENDEROBJ build(final GETTER<Integer> ier)
/*     */         {
/* 200 */           GuiSection s = new GuiSection();
/*     */           
/* 202 */           GStat a = new GStat()
/*     */             {
/*     */               
/*     */               public void update(GText text)
/*     */               {
/* 207 */                 HGROUP h = (HGROUP)HGROUP.all().get(((Integer)ier.get()).intValue());
/* 208 */                 furnishing.format(text, h);
/*     */               }
/*     */             };
/*     */           
/* 212 */           GButt.Glow glow = new GButt.Glow((SPRITE)(SPRITES.icons()).s.cog)
/*     */             {
/*     */               protected void clickA()
/*     */               {
/* 216 */                 HGROUP h = (HGROUP)HGROUP.all().get(((Integer)ier.get()).intValue());
/*     */                 
/* 218 */                 if (h.type == HCLASSES.CITIZEN()) {
/* 219 */                   (VIEW.s()).ui.standing.openAccess(h.race);
/*     */                 }
/*     */                 
/* 222 */                 super.clickA();
/*     */               }
/*     */ 
/*     */ 
/*     */               
/*     */               public void hoverInfoGet(GUI_BOX text) {
/* 228 */                 HGROUP h = (HGROUP)HGROUP.all().get(((Integer)ier.get()).intValue());
/* 229 */                 if (h.type != HCLASSES.NOBLE())
/* 230 */                   text.text(UIHomesTable.¤¤FurnishClick); 
/* 231 */                 text.NL(8);
/*     */                 
/* 233 */                 super.hoverInfoGet(text);
/*     */               }
/*     */             };
/*     */ 
/*     */           
/* 238 */           s.add((RENDEROBJ)glow);
/* 239 */           s.addRightC(2, (RENDEROBJ)a.r());
/*     */           
/* 241 */           return (RENDEROBJ)s;
/*     */         }
/*     */       };
/* 244 */     bu.column(furnishing.name, size + 20, b);
/*     */     
/* 246 */     b = new GTableBuilder.GRowBuilder()
/*     */       {
/*     */         
/*     */         public RENDEROBJ build(final GETTER<Integer> ier)
/*     */         {
/* 251 */           return (RENDEROBJ)new GButt.ButtPanel((SPRITE)(SPRITES.icons()).s.arrow_right)
/*     */             {
/*     */               protected void clickA()
/*     */               {
/* 255 */                 HGROUP h = (HGROUP)HGROUP.all().get(((Integer)ier.get()).intValue());
/* 256 */                 UIHomesTable.null.access$0(UIHomesTable.null.this).search(h);
/* 257 */                 super.clickA();
/*     */               }
/*     */ 
/*     */               
/*     */               protected void renAction() {
/* 262 */                 HGROUP h = (HGROUP)HGROUP.all().get(((Integer)ier.get()).intValue());
/* 263 */                 activeSet(((STATS.HOME()).GETTER.hasSearched.data(h.type).get(h.race) > 0));
/*     */               }
/*     */ 
/*     */               
/*     */               public void hoverInfoGet(GUI_BOX text) {
/* 268 */                 text.text(UIHomesTable.¤¤ClickToGoToFirstHomeless);
/* 269 */                 text.NL();
/*     */               }
/*     */             };
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 276 */     bu.column(null, 48, b);
/*     */     
/* 278 */     add((RENDEROBJ)bu.createHeight(HEIGHT, true));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 284 */     super.render(r, ds);
/* 285 */     if (this.subject != null) {
/* 286 */       (VIEW.s().getWindow()).centerer.set(this.subject.body().cX(), this.subject.body().cY());
/* 287 */       SETT.OVERLAY().add((ENTITY)this.subject);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void search(HGROUP t) {
/* 293 */     ENTITY[] ee = SETT.ENTITIES().getAllEnts();
/*     */     
/* 295 */     for (int i = 0; i < ee.length; i++) {
/* 296 */       if (this.hi >= ee.length)
/* 297 */         this.hi = 0; 
/* 298 */       ENTITY e = SETT.ENTITIES().getAllEnts()[this.hi];
/* 299 */       this.hi++;
/* 300 */       if (e instanceof Humanoid) {
/* 301 */         Humanoid h = (Humanoid)e;
/*     */         
/* 303 */         if ((STATS.HOME()).GETTER.hasSearched.indu().get(h.indu()) != 0)
/*     */         {
/*     */           
/* 306 */           if (t == HGROUP.get(h)) {
/* 307 */             this.subject = h;
/*     */             return;
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static abstract class Data
/*     */   {
/*     */     final CharSequence name;
/*     */     final CharSequence desc;
/*     */     
/*     */     Data(CharSequence name, CharSequence desc) {
/* 322 */       this.name = name;
/* 323 */       this.desc = desc;
/*     */     }
/*     */ 
/*     */     
/*     */     abstract GText format(GText param1GText, HGROUP param1HGROUP);
/*     */   }
/*     */   
/*     */   private static GTableBuilder.GRowBuilder row(final Data data) {
/* 331 */     return new GTableBuilder.GRowBuilder()
/*     */       {
/*     */         public RENDEROBJ build(final GETTER<Integer> ier)
/*     */         {
/* 335 */           return (RENDEROBJ)(new GStat()
/*     */             {
/*     */               public void update(GText text)
/*     */               {
/* 339 */                 HGROUP h = (HGROUP)HGROUP.all().get(((Integer)ier.get()).intValue());
/* 340 */                 data.format(text, h);
/*     */               }
/* 343 */             }).r(DIR.NW);
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\home\UIHomesTable.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */