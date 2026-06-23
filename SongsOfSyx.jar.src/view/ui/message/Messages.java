/*     */ package view.ui.message;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.save.Savable;
/*     */ import game.time.TIME;
/*     */ import init.constant.C;
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.file.JsonE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import snake2d.util.sprite.text.Text;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.panel.GPanel;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import util.text.DicTime;
/*     */ import view.interrupter.IDebugPanel;
/*     */ import view.interrupter.InterManager;
/*     */ import view.interrupter.Interrupter;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ public final class Messages {
/*  50 */   private final ArrayList<Message> all = new ArrayList(256);
/*  51 */   private int unread = 0;
/*     */   private final List list;
/*     */   private final IMessage imess;
/*     */   private final InterManager manager;
/*  55 */   private final KeyMap<String> hideMap = new KeyMap();
/*  56 */   private final ArrayList<Message> queued = new ArrayList(16); private static final String fn = "BlockedMessages";
/*     */   
/*     */   public Messages(InterManager manager) {
/*  59 */     this.manager = manager;
/*  60 */     this.list = new List();
/*  61 */     this.imess = new IMessage();
/*  62 */     IDebugPanel.add("Send message", new ACTION()
/*     */         {
/*     */           public void exe() {
/*  65 */             Messages.debug();
/*     */           }
/*     */         });
/*  68 */     read();
/*  69 */     GAME.saver().add(new Savable("MESSAGES")
/*     */         {
/*     */           public void save(FilePutter f)
/*     */           {
/*  73 */             f.mark(this);
/*  74 */             f.i(Messages.this.all.size());
/*  75 */             for (Message m : Messages.this.all) {
/*  76 */               f.object(m);
/*     */             }
/*     */           }
/*     */           
/*     */           public void load(FileGetter f) throws IOException {
/*  81 */             f.check(this);
/*  82 */             Messages.this.unread = 0;
/*     */             
/*  84 */             int am = f.i();
/*     */             
/*  86 */             for (int i = 0; i < am; i++) {
/*  87 */               Message m = (Message)f.object(true);
/*  88 */               if (m != null) {
/*  89 */                 Messages.this.all.add(m);
/*  90 */                 if (!m.isRead) {
/*  91 */                   Messages.this.unread++;
/*     */                 }
/*     */               } 
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 103 */   private static CharSequence ¤¤delete = "¤Delete all read messages.";
/* 104 */   private static CharSequence ¤¤PauseD = "¤When selected, pauses the game and shows this type of message upon arrival.";
/* 105 */   private static CharSequence ¤¤title = "¤Title";
/* 106 */   private static CharSequence ¤¤Arrived = "¤Arrived";
/* 107 */   private static CharSequence ¤¤Messages = "¤Messages";
/*     */   static {
/* 109 */     D.ts(Messages.class);
/*     */   }
/*     */ 
/*     */   
/*     */   private void read() {
/* 114 */     if (!(PATHS.local()).PROFILE.exists("BlockedMessages"))
/*     */       return;  try {
/*     */       byte b; int i; String[] arrayOfString;
/* 117 */       for (i = (arrayOfString = (new Json((PATHS.local()).PROFILE.gets("BlockedMessages"))).values("M")).length, b = 0; b < i; ) { String s = arrayOfString[b];
/* 118 */         if (s != null && !s.equals("null"))
/* 119 */           this.hideMap.put(s, s);  b++; }
/*     */     
/* 121 */     } catch (Exception e) {
/* 122 */       e.printStackTrace(System.out);
/* 123 */       this.hideMap.clear();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void flush() {
/*     */     try {
/* 131 */       String[] vv = new String[this.hideMap.all().size()];
/* 132 */       int i = 0;
/* 133 */       for (String s : this.hideMap.all()) {
/* 134 */         vv[i++] = s;
/*     */       }
/* 136 */       JsonE j = new JsonE();
/* 137 */       j.add("M", vv);
/*     */       
/* 139 */       if (!(PATHS.local()).PROFILE.exists("BlockedMessages"))
/* 140 */         (PATHS.local()).PROFILE.create("BlockedMessages"); 
/* 141 */       j.save((PATHS.local()).PROFILE.get("BlockedMessages"));
/* 142 */     } catch (Exception e) {
/* 143 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void debug() {
/* 149 */     MessageText t = new MessageText("Debugging");
/* 150 */     t.paragraph("hello!");
/* 151 */     t.paragraph("goodbye!");
/* 152 */     t.send();
/*     */     
/* 154 */     t = new MessageText("Debugging Long");
/* 155 */     t.paragraph("hello again!");
/* 156 */     for (int i = 0; i < 10; i++) {
/* 157 */       t.paragraph("You're taking too long to make this game. I'm so glad you're making this game Jake, isn't it a lot of fun! Could you add Godzilla monsters please, I so much want them. Until next time, ta ta!");
/*     */     }
/* 159 */     t.send();
/*     */   }
/*     */ 
/*     */   
/*     */   boolean add(Message m) {
/* 164 */     if (!this.all.hasRoom()) {
/* 165 */       remove(0);
/*     */     }
/*     */ 
/*     */     
/* 169 */     this.all.add(m);
/* 170 */     m.section = m.makeSection();
/* 171 */     this.unread++;
/*     */     
/* 173 */     if (this.hideMap.containsKey(m.key)) {
/* 174 */       m.isRead = true;
/* 175 */       this.unread--;
/* 176 */       return false;
/*     */     } 
/*     */     
/* 179 */     if (this.imess.isActivated()) {
/* 180 */       if (this.queued.hasRoom())
/* 181 */         this.queued.add(m); 
/*     */     } else {
/* 183 */       this.imess.act(m);
/* 184 */     }  return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private void remove(int index) {
/* 189 */     if (index < 0 || index >= this.all.size())
/*     */       return; 
/* 191 */     if (!((Message)this.all.get(index)).isRead) {
/* 192 */       this.unread--;
/*     */     }
/* 194 */     this.all.removeOrdered(index);
/*     */   }
/*     */   
/*     */   GButt.Panel getButt() {
/* 198 */     GButt.Panel b = new GButt.Panel((SPRITE)(SPRITES.icons()).m.openscroll) {
/* 199 */         private Text nr = new Text((UI.FONT()).M, 10);
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 203 */           isActive = (Messages.this.all.size() > 0);
/* 204 */           activeSet(isActive);
/* 205 */           isSelected = Messages.this.list.isActivated();
/* 206 */           super.render(r, ds, isActive, isSelected, isHovered);
/*     */           
/* 208 */           if (Messages.this.unread > 0 && Messages.this.all.size() > 0) {
/* 209 */             this.nr.clear().add(Messages.this.unread).adjustWidth();
/* 210 */             if (!isHovered && TIME.currentSecond() - ((Message)Messages.this.all.last()).currentSecond < 3.0D) {
/* 211 */               COLOR.WHITE2WHITE.bind();
/* 212 */               int i = body().x1() + (this.body.width() - 24) / 2;
/* 213 */               int j = body().y1() + (this.body.height() - 24) / 2;
/* 214 */               (SPRITES.icons()).m.openscroll.render(r, i, j);
/*     */             } 
/*     */             
/* 217 */             int x = body().x1() + (this.body.width() - this.nr.width()) / 2;
/* 218 */             int y = body().y1() + (this.body.height() - this.nr.height()) / 2;
/* 219 */             COLOR.WHITE100.bind();
/* 220 */             this.nr.render(r, x - 1, y - 1);
/* 221 */             COLOR.RED50.bind();
/* 222 */             this.nr.render(r, x, y);
/* 223 */             COLOR.unbind();
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 229 */           if (Messages.this.all.size() > 0)
/* 230 */             Messages.this.list.act(); 
/*     */         }
/*     */       };
/* 233 */     b.hoverInfoSet(¤¤Messages);
/* 234 */     return b;
/*     */   }
/*     */   
/*     */   public int size() {
/* 238 */     return this.all.size();
/*     */   }
/*     */   
/*     */   public boolean activated() {
/* 242 */     return !(!this.list.isActivated() && !this.imess.isActivated());
/*     */   }
/*     */   
/*     */   public int unread() {
/* 246 */     return this.unread;
/*     */   }
/*     */   
/*     */   public double currentSecond() {
/* 250 */     if (this.all.size() == 0)
/* 251 */       return 0.0D; 
/* 252 */     return ((Message)this.all.last()).currentSecond;
/*     */   }
/*     */   
/*     */   public void activate() {
/* 256 */     if (this.all.size() > 0)
/* 257 */       this.list.act(); 
/*     */   }
/*     */   
/*     */   public void hide() {
/* 261 */     this.imess.close.exe();
/*     */   }
/*     */   
/*     */   public void hideAll() {
/* 265 */     while (this.imess.isActivated())
/* 266 */       this.imess.close.exe(); 
/* 267 */     this.list.hide();
/*     */   }
/*     */   
/*     */   public void reopen(Message mess) {
/* 271 */     this.imess.act(mess);
/*     */   }
/*     */ 
/*     */   
/*     */   private class List
/*     */     extends Interrupter
/*     */   {
/*     */     private final GuiSection section;
/*     */     
/*     */     private boolean removed = false;
/*     */     
/*     */     protected List() {
/* 283 */       GTableBuilder builder = new GTableBuilder()
/*     */         {
/*     */           public int nrOFEntries()
/*     */           {
/* 287 */             return (Messages.List.access$0(Messages.List.this)).all.size();
/*     */           }
/*     */ 
/*     */           
/*     */           public void click(int index) {
/* 292 */             if (Messages.List.this.removed) {
/* 293 */               Messages.List.this.removed = false;
/*     */               return;
/*     */             } 
/* 296 */             Message message = (Message)(Messages.List.access$0(Messages.List.this)).all.get((Messages.List.access$0(Messages.List.this)).all.size() - 1 - index);
/* 297 */             if (message != null) {
/* 298 */               (Messages.List.access$0(Messages.List.this)).imess.act(message);
/*     */             }
/*     */           }
/*     */         };
/* 302 */       builder.column(Messages.¤¤title, 200, new GTableBuilder.GRowBuilder()
/*     */           {
/*     */             public RENDEROBJ build(final GETTER<Integer> ier) {
/* 305 */               return (RENDEROBJ)(new GStat()
/*     */                 {
/*     */                   public void update(GText text)
/*     */                   {
/* 309 */                     Message m = (Message)(Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this))).all.get((Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this))).all.size() - 1 - ((Integer)ier.get()).intValue());
/* 310 */                     if (m == null)
/*     */                       return; 
/* 312 */                     if (m.title().length() >= 20) {
/* 313 */                       text.add(m.title(), 0, 20);
/* 314 */                       text.add('.').add('.').add('.');
/*     */                     } else {
/* 316 */                       text.add(m.title());
/*     */                     } 
/* 318 */                     if (m.isRead) {
/* 319 */                       text.color(COLOR.WHITE65);
/*     */                     } else {
/* 321 */                       text.color(COLOR.WHITE100);
/*     */                     } 
/*     */                   }
/* 324 */                 }).r(DIR.NW);
/*     */             }
/*     */           });
/*     */       
/* 328 */       builder.column(Messages.¤¤Arrived, 200, new GTableBuilder.GRowBuilder()
/*     */           {
/*     */             public RENDEROBJ build(final GETTER<Integer> ier) {
/* 331 */               return (RENDEROBJ)(new GStat()
/*     */                 {
/*     */                   public void update(GText text)
/*     */                   {
/* 335 */                     Message m = (Message)(Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this))).all.get((Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this))).all.size() - 1 - ((Integer)ier.get()).intValue());
/* 336 */                     if (m == null)
/*     */                       return; 
/* 338 */                     int t = (int)(TIME.currentSecond() - m.currentSecond);
/* 339 */                     DicTime.setAgo((Str)text, t);
/*     */                     
/* 341 */                     if (m.isRead) {
/* 342 */                       text.color(COLOR.WHITE65);
/*     */                     } else {
/* 344 */                       text.color(COLOR.WHITE100);
/*     */                     } 
/*     */                   }
/* 347 */                 }).r(DIR.NW);
/*     */             }
/*     */           });
/*     */       
/* 351 */       builder.column("", 36, new GTableBuilder.GRowBuilder()
/*     */           {
/*     */             public RENDEROBJ build(final GETTER<Integer> ier) {
/* 354 */               return (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).s.cancel)
/*     */                 {
/*     */                   protected void clickA() {
/* 357 */                     Message m = (Message)(Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this))).all.get((Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this))).all.size() - 1 - ((Integer)ier.get()).intValue());
/* 358 */                     if (m == null) {
/*     */                       return;
/*     */                     }
/* 361 */                     Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this)).remove((Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this))).all.size() - 1 - ((Integer)ier.get()).intValue());
/* 362 */                     (Messages.List.null.access$0(Messages.List.null.this)).removed = true;
/*     */                   }
/* 364 */                 }).hoverInfoSet(Dic.¤¤remove);
/*     */             }
/*     */           });
/*     */       
/* 368 */       builder.column("", 36, new GTableBuilder.GRowBuilder()
/*     */           {
/*     */             public RENDEROBJ build(final GETTER<Integer> ier) {
/* 371 */               return (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).s.clock)
/*     */                 {
/*     */                   protected void clickA() {
/* 374 */                     Message m = (Message)(Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this))).all.get((Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this))).all.size() - 1 - ((Integer)ier.get()).intValue());
/* 375 */                     if (m == null) {
/*     */                       return;
/*     */                     }
/* 378 */                     if ((Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this))).hideMap.containsKey(m.key)) {
/* 379 */                       (Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this))).hideMap.remove(m.key);
/*     */                     } else {
/* 381 */                       (Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this))).hideMap.put(m.key, m.key);
/*     */                     } 
/* 383 */                     Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this)).flush();
/*     */                   }
/*     */ 
/*     */                   
/*     */                   protected void renAction() {
/* 388 */                     Message m = (Message)(Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this))).all.get((Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this))).all.size() - 1 - ((Integer)ier.get()).intValue());
/* 389 */                     selectedSet((m != null && !(Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this))).hideMap.containsKey(m.key)));
/*     */                   }
/* 392 */                 }).hoverInfoSet(Messages.¤¤PauseD);
/*     */             }
/*     */           });
/*     */ 
/*     */       
/* 397 */       this.section = builder.create(15, true);
/*     */       
/* 399 */       GButt.ButtPanel buttPanel = new GButt.ButtPanel(Messages.¤¤delete)
/*     */         {
/*     */           protected void clickA() {
/* 402 */             for (int i = 0; i < (Messages.List.access$0(Messages.List.this)).all.size(); i++) {
/* 403 */               if (((Message)(Messages.List.access$0(Messages.List.this)).all.get(i)).isRead) {
/* 404 */                 (Messages.List.access$0(Messages.List.this)).all.removeOrdered(i);
/* 405 */                 i--;
/*     */               } 
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 412 */             activeSet(((Messages.List.access$0(Messages.List.this)).all.size() - (Messages.List.access$0(Messages.List.this)).unread > 0));
/*     */           }
/*     */         };
/* 415 */       buttPanel.body().centerX((BODY_HOLDER)this.section).moveY1((this.section.body().y2() + 10));
/* 416 */       this.section.add((RENDEROBJ)buttPanel);
/*     */       
/* 418 */       GPanel p = new GPanel();
/* 419 */       p.set((RECTANGLE)this.section.body());
/*     */       
/* 421 */       p.setCloseAction(new ACTION()
/*     */           {
/*     */             public void exe() {
/* 424 */               Messages.List.this.hide();
/*     */             }
/*     */           });
/* 427 */       p.body().centerY(C.DIM());
/* 428 */       p.body().centerX((C.WIDTH() / 2), C.WIDTH());
/* 429 */       this.section.body().centerIn((BODY_HOLDER)p);
/* 430 */       this.section.add((RENDEROBJ)p);
/* 431 */       this.section.moveLastToBack();
/*     */       
/* 433 */       p.setTitle(Messages.¤¤Messages, (UI.FONT()).H2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void act() {
/* 440 */       show(Messages.this.manager);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 445 */       this.section.hover(mCoo);
/* 446 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void mouseClick(MButt button) {
/* 451 */       if (button == MButt.LEFT)
/* 452 */         this.section.click(); 
/* 453 */       if (button == MButt.RIGHT) {
/* 454 */         hide();
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public void hide() {
/* 460 */       super.hide();
/*     */     }
/*     */ 
/*     */     
/*     */     protected void hoverTimer(GBox text) {
/* 465 */       this.section.hoverInfoGet((GUI_BOX)text);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean render(Renderer r, float ds) {
/* 470 */       this.section.render((SPRITE_RENDERER)r, ds);
/* 471 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean update(float ds) {
/* 477 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private class IMessage
/*     */     extends Interrupter
/*     */   {
/* 484 */     private final GPanel panel = (new GPanel()).setBig();
/*     */     private Message m;
/*     */     
/* 487 */     private final GButt.ButtPanel show = (new GButt.ButtPanel((UI.FONT()).S.getText(Dic.¤¤Alert))
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text)
/*     */         {
/* 491 */           text.text(Messages.¤¤PauseD);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 496 */           selectedSet(!(Messages.IMessage.access$1(Messages.IMessage.this)).hideMap.containsKey(Messages.IMessage.this.m.key));
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 501 */           if ((Messages.IMessage.access$1(Messages.IMessage.this)).hideMap.containsKey(Messages.IMessage.this.m.key)) {
/* 502 */             (Messages.IMessage.access$1(Messages.IMessage.this)).hideMap.remove(Messages.IMessage.this.m.key);
/*     */           } else {
/* 504 */             (Messages.IMessage.access$1(Messages.IMessage.this)).hideMap.put(Messages.IMessage.this.m.key, Messages.IMessage.this.m.key);
/*     */           } 
/* 506 */           Messages.IMessage.access$1(Messages.IMessage.this).flush();
/*     */         }
/* 508 */       }).icon((SPRITE)(UI.icons()).s.clock);
/*     */     
/* 510 */     ACTION close = new ACTION()
/*     */       {
/*     */         public void exe() {
/* 513 */           Messages.IMessage.this.hide();
/* 514 */           if (Messages.IMessage.this.m == null)
/*     */             return; 
/* 516 */           if (!Messages.IMessage.this.m.isRead)
/* 517 */             (Messages.IMessage.access$1(Messages.IMessage.this)).unread--; 
/* 518 */           Messages.IMessage.this.m.isRead = true;
/* 519 */           if (!(Messages.IMessage.access$1(Messages.IMessage.this)).queued.isEmpty()) {
/* 520 */             Messages.IMessage.this.act((Message)(Messages.IMessage.access$1(Messages.IMessage.this)).queued.removeLast());
/*     */           }
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*     */     void act(Message m) {
/* 527 */       if (VIEW.b().isActive())
/*     */         return; 
/* 529 */       this.m = m;
/* 530 */       if (m.section == null)
/* 531 */         m.section = m.makeSection(); 
/* 532 */       this.panel.inner().set((BODY_HOLDER)m.section);
/* 533 */       this.panel.inner().setWidth(Math.max(this.panel.inner().width(), 500));
/* 534 */       this.panel.inner().incrH(20.0D);
/* 535 */       this.panel.body().centerIn(C.DIM());
/* 536 */       m.section.body().centerX((RECTANGLE)this.panel.inner());
/* 537 */       m.section.body().moveY1(this.panel.inner().y1());
/* 538 */       this.show.body.moveX2((m.section.body().x2() - 8));
/* 539 */       this.show.body.moveY1((this.panel.inner().y2() + 2));
/* 540 */       this.panel.setCloseAction(this.close);
/* 541 */       if (m.title() != null && m.title().length() > 0) {
/* 542 */         this.panel.setTitle(m.title());
/*     */       } else {
/* 544 */         this.panel.setTitle(Dic.¤¤Clear);
/*     */       } 
/* 546 */       show(Messages.this.manager);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 551 */       this.panel.hover(mCoo);
/* 552 */       if (this.m.section instanceof HOVERABLE)
/* 553 */         ((HOVERABLE)this.m.section).hover(mCoo); 
/* 554 */       this.show.hover(mCoo);
/* 555 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void mouseClick(MButt button) {
/* 560 */       if (button == MButt.LEFT) {
/* 561 */         this.panel.click();
/* 562 */         if (this.m.section instanceof CLICKABLE)
/* 563 */           ((CLICKABLE)this.m.section).click(); 
/* 564 */         this.show.click();
/* 565 */       } else if (button == MButt.RIGHT) {
/* 566 */         this.close.exe();
/*     */       } 
/*     */     }
/*     */     
/*     */     protected void hoverTimer(GBox text) {
/* 571 */       if (this.panel.hoveredIs())
/* 572 */         this.panel.hoverInfoGet((GUI_BOX)text); 
/* 573 */       if (this.m.section instanceof HOVERABLE)
/* 574 */         ((HOVERABLE)this.m.section).hoverInfoGet((GUI_BOX)text); 
/* 575 */       if (this.show.hoveredIs()) {
/* 576 */         this.show.hoverInfoGet((GUI_BOX)text);
/*     */       }
/*     */     }
/*     */     
/*     */     protected boolean render(Renderer r, float ds) {
/* 581 */       this.panel.render((SPRITE_RENDERER)r, ds);
/* 582 */       this.m.section.render((SPRITE_RENDERER)r, ds);
/* 583 */       this.show.render((SPRITE_RENDERER)r, ds);
/* 584 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean update(float ds) {
/* 589 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\message\Messages.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */