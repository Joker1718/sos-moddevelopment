/*     */ package game.event.engine;
/*     */ import game.GAME;
/*     */ import game.event.actions.EventAction;
/*     */ import game.faction.FACTIONS;
/*     */ import init.settings.S;
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
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GTextR;
/*     */ import util.gui.table.GRows;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.text.D;
/*     */ import view.main.VIEW;
/*     */ import view.ui.message.MessageSection;
/*     */ 
/*     */ class EventMessage extends MessageSection {
/*  30 */   private static CharSequence ¤¤active = "This event is no longer relevant.";
/*     */   static {
/*  32 */     D.ts(EventMessage.class);
/*     */   }
/*     */ 
/*     */   
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   private final String eKey;
/*     */   
/*     */   private final int ei;
/*     */   private final EContext data;
/*     */   private final int iteration;
/*  43 */   private int choice = -1;
/*     */   
/*     */   private final String[] mess;
/*     */   
/*     */   public EventMessage(Event abs, EContext data) {
/*  48 */     super(abs.info.name);
/*  49 */     this.eKey = abs.key;
/*  50 */     this.ei = abs.allIndex;
/*  51 */     this.mess = new String[abs.info.messages.length];
/*  52 */     for (int i = 0; i < this.mess.length; i++) {
/*  53 */       Str s = new Str(128);
/*  54 */       s.add(abs.info.messages[i]);
/*  55 */       EContext.insert.set(s, data);
/*  56 */       this.mess[i] = String.valueOf(s);
/*     */     } 
/*     */     
/*  59 */     this.data = new EContext(data);
/*  60 */     this.iteration = GAME.EVENT().occ(abs);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void make(GuiSection section) {
/*  66 */     final Event e = GAME.EVENT().read(this.ei, this.eKey);
/*  67 */     if (e == null) {
/*     */       return;
/*     */     }
/*  70 */     LinkedList<RENDEROBJ> rr = new LinkedList(); byte b; int j;
/*     */     String[] arrayOfString;
/*  72 */     for (j = (arrayOfString = this.mess).length, b = 0; b < j; ) { CharSequence par = arrayOfString[b]; byte b1; final int k;
/*     */       CharSequence[] arrayOfCharSequence;
/*  74 */       for (k = (arrayOfCharSequence = (UI.FONT()).M.getRows(par, 800)).length, b1 = 0; b1 < k; ) { CharSequence s = arrayOfCharSequence[b1];
/*  75 */         if (s.length() > 0)
/*  76 */           rr.add(new GTextR((UI.FONT()).M, s)); 
/*     */         b1++; }
/*     */       
/*  79 */       rr.add(new RENDEROBJ.RenderDummy(10, 8));
/*     */       b++; }
/*     */     
/*  82 */     if (this.data.coo.x() >= 0) {
/*  83 */       GButt.ButtPanel buttPanel = new GButt.ButtPanel((SPRITE)(UI.icons()).m.crossair)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/*  87 */             (VIEW.s().getWindow()).centererTile.set((COORDINATE)EventMessage.this.data.coo);
/*     */           }
/*     */         };
/*  90 */       buttPanel.body.setDim(100.0D);
/*  91 */       section.addRelBody(8, DIR.S, (RENDEROBJ)buttPanel);
/*  92 */       rr.add(new RENDEROBJ.RenderDummy(10, 8));
/*     */     } 
/*     */     
/*  95 */     for (EventAction a : e.on_spawn) {
/*  96 */       if (!a.hideUI) {
/*  97 */         a.addToMessageBody((LISTE)rr, e, this.data, (RECTANGLE)section.body());
/*  98 */         rr.add(new RENDEROBJ.RenderDummy(10, 8));
/*     */       } 
/*     */     } 
/*     */     
/* 102 */     GRows butts = new GRows(2);
/*     */     
/* 104 */     int i = 0;
/* 105 */     for (EChoice c : e.choices) {
/* 106 */       final int k = i++;
/* 107 */       GButt.ButtPanel buttPanel = new GButt.ButtPanel(c.name)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 111 */             VIEW.messages().hide();
/* 112 */             for (EventAction a : c.actions) {
/* 113 */               if (a.problem(e, EventMessage.this.data) != null) {
/*     */                 return;
/*     */               }
/*     */             } 
/* 117 */             if (!c.request.passes(FACTIONS.player()))
/*     */               return; 
/* 119 */             GAME.EVENT().choiceSelect(e, k);
/*     */ 
/*     */             
/* 122 */             EventMessage.this.choice = k;
/* 123 */             for (EventAction a : c.actions) {
/* 124 */               a.exe(e, EventMessage.this.data);
/*     */             }
/* 126 */             if (GAME.EVENT().current() == e) {
/* 127 */               GAME.EVENT().set(null, false, false, false, false);
/*     */             }
/* 129 */             super.clickA();
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 135 */             super.render(r, ds, isActive, isSelected, isHovered);
/* 136 */             if (!c.request.passes(FACTIONS.player())) {
/* 137 */               OPACITY.O50.bind();
/* 138 */               COLOR.WHITE50.render(r, (RECTANGLE)this.body, -2);
/* 139 */               OPACITY.unbind();
/*     */               return;
/*     */             } 
/* 142 */             for (EventAction a : c.actions) {
/* 143 */               if (a.problem(e, EventMessage.this.data) != null) {
/* 144 */                 OPACITY.O50.bind();
/* 145 */                 COLOR.WHITE50.render(r, (RECTANGLE)this.body, -2);
/* 146 */                 OPACITY.unbind();
/*     */                 return;
/*     */               } 
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 155 */             selectedSet((EventMessage.this.choice == k));
/* 156 */             activeSet((EventMessage.this.iteration == GAME.EVENT().occ(e) && GAME.EVENT().current() == e));
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 161 */             GBox b = (GBox)text;
/* 162 */             b.title(c.name);
/*     */             
/* 164 */             if (EventMessage.this.iteration != GAME.EVENT().occ(e) || GAME.EVENT().current() != e) {
/* 165 */               b.error(EventMessage.¤¤active);
/* 166 */               b.NL();
/* 167 */               if (!(S.get()).developer) {
/*     */                 return;
/*     */               }
/*     */             } 
/*     */ 
/*     */             
/* 173 */             for (EventAction a : c.actions) {
/* 174 */               if (!a.hideUI) {
/* 175 */                 a.hover(b, e, EventMessage.this.data);
/* 176 */                 b.NL(8);
/*     */               } 
/*     */             } 
/* 179 */             b.NL();
/* 180 */             for (EventAction a : c.actions) {
/* 181 */               CharSequence p = a.problem(e, EventMessage.this.data);
/* 182 */               if (p != null) {
/* 183 */                 b.error(p);
/* 184 */                 b.NL();
/*     */               } 
/*     */             } 
/*     */             
/* 188 */             if (c.request.all().size() > 0) {
/* 189 */               c.request.hover(text, FACTIONS.player());
/*     */             }
/*     */             
/* 192 */             if ((S.get()).developer) {
/* 193 */               for (EventAction a : c.actions) {
/* 194 */                 b.text(a.key);
/*     */               }
/*     */             }
/* 197 */             super.hoverInfoGet(text);
/*     */           }
/*     */         };
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 204 */       buttPanel.body.setWidth(400.0D);
/*     */       
/* 206 */       butts.add((RENDEROBJ)buttPanel);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 211 */     SPRITE icon = null;
/* 212 */     if (icon == null && e.selection.indu.useAsIcon)
/* 213 */       icon = this.data.indu.sprite(); 
/* 214 */     if (icon == null && e.selection.reg.useAsIcon)
/* 215 */       icon = this.data.regs.sprite(); 
/* 216 */     if (icon == null && e.selection.faction.useAsIcon)
/* 217 */       icon = this.data.faction.sprite(); 
/* 218 */     if (icon == null && e.selection.royalty.useAsIcon)
/* 219 */       icon = this.data.royalty.sprite(); 
/* 220 */     if (icon == null) {
/* 221 */       icon = e.info.icon;
/*     */     }
/*     */ 
/*     */     
/* 225 */     int hmax = 700 - icon.height() - butts.height() - 16;
/* 226 */     for (RENDEROBJ r : rr) {
/* 227 */       hmax -= r.body().height();
/*     */     }
/*     */     
/* 230 */     if (hmax > 0) {
/* 231 */       for (RENDEROBJ o : rr)
/* 232 */         section.addDown(0, o); 
/*     */     } else {
/* 234 */       GScrollRows sr = new GScrollRows((Iterable)rr, 700 - icon.height() - butts.height() - 16);
/* 235 */       section.addRelBody(8, DIR.S, (RENDEROBJ)sr.view());
/*     */     } 
/*     */     
/* 238 */     final SPRITE ic = icon;
/* 239 */     if (icon != null) {
/* 240 */       int sc = 1;
/* 241 */       if (icon.width() < 64) {
/* 242 */         sc = 2;
/*     */       }
/*     */       
/* 245 */       SPRITE.Imp imp = new SPRITE.Imp(icon.width() * sc, icon.height() * sc)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 249 */             ic.render(r, X1, X2, Y1, Y2);
/*     */           }
/*     */         };
/*     */       
/* 253 */       section.addRelBody(8, DIR.N, (SPRITE)imp);
/*     */     } 
/*     */     
/* 256 */     for (RENDEROBJ o : butts.rowsCentered(900))
/* 257 */       section.addRelBody(0, DIR.S, o); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\engine\EventMessage.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */