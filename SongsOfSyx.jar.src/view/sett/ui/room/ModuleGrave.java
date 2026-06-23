/*     */ package view.sett.ui.room;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.spirit.grave.GraveData;
/*     */ import settlement.room.spirit.grave.GraveInfo;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GGrid;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.gui.table.GTableSorter;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.ISidePanel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class ModuleGrave
/*     */   implements Modules.ModuleMaker
/*     */ {
/*     */   public ModuleGrave(Init init) {}
/*     */   
/*     */   public void make(RoomBlueprint p, LISTE<UIRoomModule> l) {
/*  46 */     if (p instanceof GraveData.GRAVE_DATA_HOLDER) {
/*  47 */       l.add(new I(((GraveData.GRAVE_DATA_HOLDER)p).graveData()));
/*     */     }
/*     */   }
/*     */   
/*     */   private final class I
/*     */     extends UIRoomModule
/*     */   {
/*     */     private final GraveData g;
/*     */     
/*     */     I(GraveData g) {
/*  57 */       this.g = g;
/*     */     }
/*     */ 
/*     */     
/*     */     public void appendManageScr(GGrid grid, GGrid text, GuiSection sExta) {
/*  62 */       text.add((RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/*  66 */               GFORMAT.iofkInv(text, ModuleGrave.I.this.g.available.get(null), ModuleGrave.I.this.g.total.get(null));
/*     */             }
/*  68 */           }).hh(this.g.available.info()));
/*     */       
/*  70 */       text.add((RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/*  74 */               GFORMAT.perc(text, ModuleGrave.I.this.g.respect.getD(null));
/*     */             }
/*  76 */           }).hh(this.g.respect.info()));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void appendTableFilters(LISTE<GTableSorter.GTFilter<RoomInstance>> filters, LISTE<GTableSorter.GTSort<RoomInstance>> sorts, LISTE<UIRoomBulkApplier> appliers) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void appendButt(GuiSection s, final GETTER<RoomInstance> ins) {
/*  87 */       DOUBLE d = new DOUBLE()
/*     */         {
/*     */           public double getD()
/*     */           {
/*  91 */             double d = ModuleGrave.I.this.g.available.get(ins.get()) / ModuleGrave.I.this.g.total.get(ins.get());
/*  92 */             return d;
/*     */           }
/*     */         };
/*     */       
/*  96 */       s.addRightC(16, (SPRITE)(SPRITES.icons()).s.death);
/*     */       
/*  98 */       s.addRightC(2, (SPRITE)new GMeter.GMeterSprite(GMeter.C_REDGREEN, d, 48, 12));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void appendPanel(GuiSection section, final GETTER<RoomInstance> get, int x1, int y1) {
/* 105 */       GuiSection se = new GuiSection();
/* 106 */       se.add((RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 110 */               GFORMAT.iofkInv(text, ModuleGrave.I.this.g.available.get(get.get()), ModuleGrave.I.this.g.total.get(get.get()));
/*     */             }
/* 112 */           }).hv(this.g.available.info()));
/*     */       
/* 114 */       se.addRightC(100, (RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 118 */               GFORMAT.perc(text, ModuleGrave.I.this.g.respect.getD(get.get()));
/*     */             }
/* 120 */           }).hv(this.g.respect.info()));
/*     */       
/* 122 */       section.addRelBody(8, DIR.S, (RENDEROBJ)se);
/*     */       
/* 124 */       GTableBuilder builder = new GTableBuilder()
/*     */         {
/*     */           public int nrOFEntries()
/*     */           {
/* 128 */             return ModuleGrave.I.this.g.total.get(get.get());
/*     */           }
/*     */         };
/*     */       
/* 132 */       builder.column(null, 350, new GTableBuilder.GRowBuilder()
/*     */           {
/*     */             public RENDEROBJ build(final GETTER<Integer> ier)
/*     */             {
/* 136 */               return (RENDEROBJ)new HOVERABLE.HoverableAbs(350, 24)
/*     */                 {
/* 138 */                   private final GText text = new GText((UI.FONT()).M, 32);
/*     */ 
/*     */                   
/*     */                   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 142 */                     GraveInfo info = (ModuleGrave.I.null.access$0(ModuleGrave.I.null.this)).g.info((Room)get.get(), ((Integer)ier.get()).intValue());
/* 143 */                     if (info != null) {
/* 144 */                       int x1 = body().x1();
/*     */ 
/*     */                       
/* 147 */                       this.text.setMaxWidth(340);
/* 148 */                       this.text.setMultipleLines(false);
/* 149 */                       this.text.lablify().clear().set(info.name());
/* 150 */                       this.text.renderCY(r, x1 + 8, body().cY());
/*     */                     } 
/*     */                   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                   
/*     */                   public void hoverInfoGet(GUI_BOX text) {
/* 162 */                     GraveInfo info = (ModuleGrave.I.null.access$0(ModuleGrave.I.null.this)).g.info((Room)get.get(), ((Integer)ier.get()).intValue());
/* 163 */                     if (info != null) {
/* 164 */                       GBox b = (GBox)text;
/* 165 */                       b.title(info.name());
/*     */                       
/* 167 */                       b.text((info.race()).info.namePosessive);
/* 168 */                       b.text((info.type()).name);
/* 169 */                       b.NL();
/*     */                       
/* 171 */                       b.textL(Dic.¤¤Age);
/* 172 */                       b.tab(6);
/* 173 */                       b.add((SPRITE)GFORMAT.i(b.text(), info.years()));
/* 174 */                       b.NL();
/*     */                       
/* 176 */                       b.NL(8);
/* 177 */                       b.textL((info.cause()).name);
/* 178 */                       b.NL();
/* 179 */                       b.add((SPRITE)b.text().add('(').add((info.cause()).desc).add(')'));
/*     */                     } 
/*     */                   }
/*     */                 };
/*     */             }
/*     */           });
/*     */       
/* 186 */       int h = ISidePanel.HEIGHT - section.body().height() - 16;
/*     */       
/* 188 */       section.addRelBody(8, DIR.S, (RENDEROBJ)builder.createHeight(h, true));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void hover(GBox box, Room i, int rx, int ry) {
/* 194 */       box.textL((this.g.available.info()).name);
/* 195 */       box.add((SPRITE)GFORMAT.iofkInv(box.text(), this.g.available.get(i), this.g.total.get(i)));
/* 196 */       box.NL(2);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\ModuleGrave.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */