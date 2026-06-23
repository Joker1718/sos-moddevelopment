/*     */ package view.sett.ui.room;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.job.ROOM_RADIUS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.Stack;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.slider.GSliderInt;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class I
/*     */   extends UIRoomModule
/*     */ {
/*     */   private final RoomBlueprint p;
/*     */   
/*     */   I(RoomBlueprint b) {
/*  56 */     this.p = b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendPanel(GuiSection section, final GETTER<RoomInstance> get, int x1, int y1) {
/*  66 */     if (this.p instanceof ROOM_RADIUS.ROOM_RADIUSE) {
/*     */       
/*  68 */       GuiSection s = new GuiSection()
/*     */         {
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text)
/*     */           {
/*  73 */             text.title((ModuleRadius.I.access$0(ModuleRadius.I.this)).¤¤NAME);
/*  74 */             text.text((ModuleRadius.I.access$0(ModuleRadius.I.this)).¤¤DESC);
/*     */           }
/*     */ 
/*     */           
/*     */           public void render(SPRITE_RENDERER r, float ds) {
/*  79 */             (ModuleRadius.I.access$0(ModuleRadius.I.this)).i = (RoomInstance)get.get();
/*  80 */             SETT.OVERLAY().roomRadius((RoomInstance)get.get(), ((ROOM_RADIUS.ROOM_RADIUS_INSTANCE)get.get()).radius());
/*  81 */             super.render(r, ds);
/*     */           }
/*     */         };
/*     */ 
/*     */       
/*  86 */       GHeader h = new GHeader(ModuleRadius.this.¤¤NAME)
/*     */         {
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/*  89 */             super.render(r, ds, isHovered);
/*     */           }
/*     */         };
/*     */       
/*  93 */       h.hoverInfoSet(ModuleRadius.this.¤¤DESC);
/*  94 */       s.add((SPRITE)(UI.icons()).m.place_ellispse, 0, 0);
/*     */       
/*  96 */       final ROOM_RADIUS.ROOM_RADIUSE r = (ROOM_RADIUS.ROOM_RADIUSE)this.p;
/*  97 */       INT.INTE i = new INT.INTE()
/*     */         {
/*     */           public int min()
/*     */           {
/* 101 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max() {
/* 106 */             return 100;
/*     */           }
/*     */ 
/*     */           
/*     */           public int get() {
/* 111 */             return r.radiusInstance((Room)get.get()).radiusRaw();
/*     */           }
/*     */ 
/*     */           
/*     */           public void set(int t) {
/* 116 */             r.radiusInstance((Room)get.get()).radiusRawSet((byte)t);
/*     */           }
/*     */         };
/* 119 */       GSliderInt m = new GSliderInt(i, 200, true, false);
/* 120 */       s.addRightC(8, (RENDEROBJ)m);
/* 121 */       section.addRelBody(2, DIR.S, (RENDEROBJ)s);
/*     */     }
/* 123 */     else if (this.p instanceof ROOM_RADIUS) {
/* 124 */       section.add((RENDEROBJ)new RENDEROBJ.RenderImp()
/*     */           {
/*     */             public void render(SPRITE_RENDERER r, float ds)
/*     */             {
/* 128 */               (ModuleRadius.I.access$0(ModuleRadius.I.this)).i = (RoomInstance)get.get();
/* 129 */               SETT.OVERLAY().roomRadius((RoomInstance)get.get(), ((ROOM_RADIUS.ROOM_RADIUS_INSTANCE)get.get()).radius());
/*     */             }
/*     */           });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(GBox box, Room room, int rx, int ry) {
/* 142 */     ModuleRadius.this.i = ModuleRadius.this.i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void problem(Stack<Str> free, LISTE<CharSequence> errors, LISTE<CharSequence> warnings, Room room, int rx, int ry) {
/* 148 */     ROOM_RADIUS.ROOM_RADIUS_INSTANCE i = (ROOM_RADIUS.ROOM_RADIUS_INSTANCE)room;
/* 149 */     if (!i.searching())
/* 150 */       errors.add(ModuleRadius.this.¤¤PROBLEM); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\ModuleRadius$I.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */