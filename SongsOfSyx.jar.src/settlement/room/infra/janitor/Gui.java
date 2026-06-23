/*     */ package settlement.room.infra.janitor;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GGrid;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.gui.table.GTableSorter;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import view.sett.ui.room.ModuleIndustry;
/*     */ import view.sett.ui.room.UIRoomBulkApplier;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ class Gui
/*     */   extends UIRoomModule.UIRoomModuleImp<JanitorInstance, ROOM_JANITOR> {
/*  36 */   private static CharSequence ¤¤Resources = "Stored Resources";
/*  37 */   private static CharSequence ¤¤Global = "Daily global consumption estimate.";
/*  38 */   private static CharSequence ¤¤Bad = "This resource can not be reached by this room, and maintenance requiring it can not be performed.";
/*     */   
/*     */   static {
/*  41 */     D.ts(Gui.class);
/*     */   }
/*     */   private int maxAm;
/*     */   
/*     */   Gui(ROOM_JANITOR s) {
/*  46 */     super(s);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  56 */     this.maxAm = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void appendPanel(GuiSection section, GGrid grid, final GETTER<JanitorInstance> getter, int x1, int y1) {
/*  61 */     final int rows = 4;
/*     */     
/*  63 */     final RESOURCE[] resourceI = new RESOURCE[RESOURCES.ALL().size()];
/*     */     
/*  65 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/*  69 */           Gui.this.maxAm = 0;
/*  70 */           for (RESOURCE res : RESOURCES.ALL()) {
/*  71 */             resourceI[res.index()] = null;
/*     */           }
/*  73 */           for (RESOURCE res : RESOURCES.ALL()) {
/*     */             
/*  75 */             if (SETT.MAINTENANCE().estimateGlobal(res) > 0.0D) {
/*  76 */               resourceI[Gui.this.maxAm] = res;
/*  77 */               Gui.this.maxAm++;
/*     */             } 
/*     */           } 
/*  80 */           (SETT.OVERLAY()).MAINTENANCE.add((RoomInstance)getter.get());
/*  81 */           super.render(r, ds);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  86 */     GTableBuilder b = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/*  90 */           return (int)Math.ceil(Gui.this.maxAm / rows);
/*     */         }
/*     */       };
/*     */     
/*  94 */     final int width = 80;
/*     */     
/*  96 */     for (int off = 0; off < 4; off++) {
/*  97 */       final int k = off;
/*  98 */       b.column(null, width, new GTableBuilder.GRowBuilder()
/*     */           {
/*     */             public RENDEROBJ build(GETTER<Integer> ier)
/*     */             {
/* 102 */               return (RENDEROBJ)new Gui.Res(width, resourceI, ier, k, getter);
/*     */             }
/*     */           });
/*     */     } 
/*     */     
/* 107 */     s.add((RENDEROBJ)new GHeader(¤¤Resources));
/* 108 */     s.addRelBody(8, DIR.E, ModuleIndustry.makeFetch(getter));
/* 109 */     s.body().incrW(48.0D);
/*     */     
/* 111 */     s.addRelBody(8, DIR.S, (RENDEROBJ)b.create(5, false));
/*     */     
/* 113 */     section.addRelBody(8, DIR.S, (RENDEROBJ)s);
/*     */   }
/*     */   
/*     */   public void hover(GBox box, JanitorInstance i) {
/*     */     super.hover(box, i);
/*     */   }
/*     */   
/*     */   protected void appendTableFilters(LISTE<GTableSorter.GTFilter<RoomInstance>> filters, LISTE<GTableSorter.GTSort<RoomInstance>> sorts, LISTE<UIRoomBulkApplier> appliers) {}
/*     */   
/*     */   private static class Res
/*     */     extends HOVERABLE.HoverableAbs
/*     */   {
/*     */     private final RESOURCE[] resourceI;
/*     */     private final GETTER<Integer> ier;
/*     */     private final int off;
/*     */     private final GETTER<JanitorInstance> getter;
/*     */     
/*     */     Res(int width, RESOURCE[] resourceI, GETTER<Integer> ier, int off, GETTER<JanitorInstance> getter) {
/* 131 */       super(width, 32);
/* 132 */       this.resourceI = resourceI;
/* 133 */       this.ier = ier;
/* 134 */       this.off = off;
/* 135 */       this.getter = getter;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 140 */       RESOURCE res = this.resourceI[((Integer)this.ier.get()).intValue() * 4 + this.off];
/* 141 */       if (res == null) {
/*     */         return;
/*     */       }
/* 144 */       GButt.ButtPanel.renderBG(r, true, false, isHovered, (RECTANGLE)this.body);
/*     */       
/* 146 */       res.icon().renderCY(r, body().x1() + 8, body().cY());
/*     */       
/* 148 */       Str.TMP.clear();
/* 149 */       Str.TMP.add(((JanitorInstance)this.getter.get()).bits.resAm(res));
/* 150 */       if (((JanitorInstance)this.getter.get()).bits.resMissing(res)) {
/* 151 */         (GCOLOR.T()).IBAD.bind();
/*     */       }
/* 153 */       (UI.FONT()).S.renderCY(r, this.body.x1() + 40, body().cY(), (CharSequence)Str.TMP);
/* 154 */       COLOR.unbind();
/*     */       
/* 156 */       GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 163 */       RESOURCE res = this.resourceI[((Integer)this.ier.get()).intValue() * 4 + this.off];
/* 164 */       if (res == null)
/*     */         return; 
/* 166 */       GBox b = (GBox)text;
/* 167 */       b.title(res.name);
/* 168 */       b.textLL(Gui.¤¤Global);
/* 169 */       b.NL();
/* 170 */       b.add((SPRITE)GFORMAT.f0(b.text(), -SETT.MAINTENANCE().estimateGlobal(res)));
/* 171 */       b.NL();
/*     */       
/* 173 */       b.NL(8);
/*     */       
/* 175 */       if (((JanitorInstance)this.getter.get()).bits.resMissing(res))
/* 176 */         b.add((SPRITE)b.text().warnify().add(Gui.¤¤Bad)); 
/* 177 */       b.NL();
/*     */       
/* 179 */       if ((S.get()).developer) {
/* 180 */         ((JanitorInstance)this.getter.get()).bits.hover(b, res, (RoomInstance)this.getter.get());
/* 181 */         b.NL();
/*     */       } 
/*     */       
/* 184 */       super.hoverInfoGet(text);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\janitor\Gui.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */